package com.uttara.spring.controllers;

import com.uttara.spring.beans.*;
import com.uttara.spring.constants.Constant;
import com.uttara.spring.services.*;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserVerificationService userVerificationService;
    @Autowired
    private UrlService urlService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private HttpService httpService;
    @RequestMapping({"","/home"})
    public String showHome(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            return "index";
        }
        else {
            model.addAttribute("user",session.getAttribute("user"));
            return "Home";
        }

    }
    @RequestMapping("/Registration")
    public String registration(Model model) {
        UserBean userBean = new UserBean();
        model.addAttribute("user",userBean);
        return "Register";
    }
    @RequestMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserBean userBean, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "Register";
        }
        else {
            String msg = userVerificationService.isValidUser(userBean);
            if(msg.equals(Constant.SUCCESS)) {
                msg = registerService.register(userBean);
                if(msg.equals(Constant.SUCCESS)) {
                    model.addAttribute("msg","Registration Successful");
                    return "Success";
                }
                else {
                    model.addAttribute("msg",msg);
                    return "Error";
                }
            }
            else {
                model.addAttribute("msg",msg);
                return "Register";
            }

        }
    }
    @RequestMapping("/showLogin")
    public String showLogin(Model model) {
        model.addAttribute("loginBean",new LoginBean());
        return "Login";
    }
    @RequestMapping("/login")
    public String login(Model model, @ModelAttribute("loginBean") @Valid LoginBean loginBean,BindingResult bindingResult,HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "Login";
        }
        UserBeanAndMessage userBeanAndMessage = registerService.login(loginBean);
        if(userBeanAndMessage.getUserBean()==null) {
            System.out.println("inside controller loginbean is "+loginBean);
            model.addAttribute("msg",userBeanAndMessage.getMessage());
            return "Login";
        }
        else {
            HttpSession session=request.getSession(true);
            session.setAttribute("user",userBeanAndMessage.getUserBean());
            model.addAttribute("user",userBeanAndMessage.getUserBean());
            return "Home";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","You have already logged out");
            return "Error";
        }
        else {
            model.addAttribute("msg","Logged out Successfully");
            session.setAttribute("user",null);
            session.invalidate();
            return "index";
        }
    }
    @RequestMapping("/showCreateListView")
    public String showCreateListView(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
//            model.addAttribute("user",session.getAttribute("user"));
            return "CreateNewList";
        }
    }
    @RequestMapping("createNewList")
    public String createList(HttpServletRequest request, Model model, @RequestParam("watchListName") String listName) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            if(listName==null||listName.trim().equals("")) {
                model.addAttribute("msg","Name can't be empty");
                return "CreateNewList";
            }
            if(movieService.doesListAlreadyExistForUser(listName,(UserBean) session.getAttribute("user"))) {
                model.addAttribute("msg","List with given name already exists");
                return "CreateNewList";
            }

            UserBeanAndMessage userBeanAndMessage = movieService.createList((UserBean) session.getAttribute("user"),listName);
            if(userBeanAndMessage.getUserBean()==null) {
                model.addAttribute("msg",userBeanAndMessage.getMessage());
                return "Error";
            }
            else {
                session.setAttribute("user",userBeanAndMessage.getUserBean());
                model.addAttribute("listName",listName);
                model.addAttribute("movieResults",new MovieResults());
                return "AddMovies";
            }
        }
    }
    @RequestMapping("searchMovieForList")
    public String searchMovieForList(
            Model model,
            @RequestParam("searchName") String searchName,
            @RequestParam("listName") String listName,
            HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            if(searchName==null||searchName.trim().equals("")) {
                model.addAttribute("msg","Name can't be empty");
                model.addAttribute("listName",listName);
                return "AddMovies";
            }
            MovieResults movieResults = movieService.searchMovie(searchName);
            model.addAttribute("movieResults",movieResults);
            model.addAttribute("listName",listName);
            return "AddMovies";
        }
    }
    @RequestMapping("addMovieToList")
    public String addMovieToList(
            @ModelAttribute("movie") Movie movie,
            Model model,
            HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            System.out.println("Insided Home controller for add movie");
//            System.out.println("movie is "+movie);
            String msg = movieService.addMovieToList(movie,movie.getWatchList().getName());
            if(!msg.equals(Constant.SUCCESS)) {
                model.addAttribute("msg",msg);
                return "Error";
            }
            else {
                model.addAttribute("movie",movie);
                model.addAttribute("msg","Movie added successfully");
                model.addAttribute("listName",movie.getWatchList().getName());
                return "MovieAdditionSuccessful";
            }
        }
    }
    @RequestMapping("viewCreatedLists")
    public String viewCreatedLists(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            UserBean userBean = (UserBean) session.getAttribute("user");
            List<WatchList> watchListsForUser= movieService.getWatchListsForUser(userBean);
            model.addAttribute("watchListsForUser",watchListsForUser);
            return "CreatedLists";
        }
    }
    @RequestMapping("viewMoviesOfList")
    public String viewMoviesOfList(Model model,HttpServletRequest request,@RequestParam("listId") Long listId,@RequestParam("listName") String listName){
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            WatchList watchList = movieService.getList(listName,((UserBean)session.getAttribute("user")).getId());
            model.addAttribute("watchList",watchList);
            model.addAttribute("listName",listName);
            model.addAttribute("commentBean",new CommentBean());
            return "MoviesOfList";
        }
    }
    @RequestMapping("showShareView")
    public String showShareView(Model model,HttpServletRequest request,@RequestParam("listName") String listName) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            model.addAttribute("listName",listName);
            model.addAttribute("emailBean",new EmailBean());
            return "ShareToFriends";
        }
    }
    @RequestMapping("share")
    public String share(
            Model model,
            HttpServletRequest request,
            @ModelAttribute("emailBean") @Valid EmailBean emailBean,
            BindingResult bindingResult) {

        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        if(bindingResult.hasErrors()) {
            return "ShareToFriends";
        }
        else {
            System.out.println(emailBean);
            emailBean.setUserBean((UserBean) session.getAttribute("user"));
            String url =urlService.createUrl(emailBean);
            if(url==null) {
                model.addAttribute("msg","Invalid arguments");
                return "Error";
            }
            else {
                emailBean.setUrl(url);
                String msg = emailService.sendEmail(emailBean);
                if(msg.equals(Constant.SUCCESS)) {
                    model.addAttribute("msg","Shared Successfully!");
                    return "Success";
                }
                else {
                    model.addAttribute("msg",msg);
                    return "Error";
                }
            }
        }
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET,headers = "Accept=*/*")
    public @ResponseBody List<String> search(@RequestParam("query") String query) {
        System.out.println("Inside autocomplete query is "+query);
        List<String> strings = new ArrayList<String>();
        MovieResults movieResults = httpService.searchMovie(query);
        for(Movie movie:movieResults.getResults()) {
            strings.add(movie.getTitle());
        }
        return strings;
    }
    @RequestMapping("viewList")
    public String viewList(Model model,@RequestParam("listName") String listName,@RequestParam("user") Long userId) {
        if(listName==null||userId==null) {
            model.addAttribute("msg","Oops something went wrong");
            return "Error";
        }
        else {
            WatchList watchList = movieService.getList(listName,userId);
            if(watchList==null) {
                model.addAttribute("msg","Oops something went wrong");
                return "Error";
            }
            else {
                model.addAttribute("watchList",watchList);
                model.addAttribute("commentBean",new CommentBean());
                return "MoviesForGuest";
            }
        }
    }
    @RequestMapping("addComment")
    public String addComment(@ModelAttribute("commentBean") @Valid CommentBean commentBean,
                             BindingResult bindingResult,
                             Model model,
                             HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(bindingResult.hasErrors()) {
            return "MoviesForGuest";
        }
        else {
            WatchList watchList = movieService.addComment(commentBean);
            if(watchList==null) {
                model.addAttribute("msg","Oops something happened");
                return "Error";
            }
            else {
                model.addAttribute("watchList",watchList);
                model.addAttribute("commentBean",new CommentBean());
                if(session==null||session.getAttribute("user")==null) {
                    return "MoviesForGuest";
                }
                else {
                    return "MoviesOfList";
                }
            }
        }
    }
    @RequestMapping("deleteList")
    public String deleteList(@RequestParam("id") Long id,HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("user")==null) {
            model.addAttribute("msg","Session expired or haven't logged in");
            return "Error";
        }
        else {
            String msg = movieService.deleteList(id);
            if(msg.equals(Constant.SUCCESS)) {
                UserBean userBean = (UserBean) session.getAttribute("user");
                List<WatchList> watchListsForUser= movieService.getWatchListsForUser(userBean);
                model.addAttribute("watchListsForUser",watchListsForUser);
                model.addAttribute("msg","Deletion Successful");
                return "CreatedLists";
            }
            else {
                model.addAttribute("msg",msg);
                return "Error";
            }
        }
    }
}
