package com.uttara.spring.services;

import com.uttara.spring.beans.*;
import com.uttara.spring.dao.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private HttpService httpService;
    public UserBeanAndMessage createList(UserBean userBean, String name) {

        if(userBean==null||name==null) {
            return new UserBeanAndMessage(null,"Invalid input");
        }
        else {
            return movieDAO.createList(userBean,name);
        }
    }

    public MovieResults searchMovie(String searchName) {
        if(searchName==null) {
            return null;
        }
        else {
            return httpService.searchMovie(searchName);
        }
    }

    public String addMovieToList(Movie movie, String name) {
        System.out.println("Insided Movie service for add movie");
//        System.out.println("movie is "+movie);
        if(movie==null||name==null||name.trim().equals("")) {
            return "Invalid input";
        }
        else {
            return movieDAO.addMovieToList(movie,name);
        }
    }

    public List<WatchList> getWatchListsForUser(UserBean userBean) {
        if(userBean==null) {
            return new ArrayList<WatchList>();
        }
        else {
            return movieDAO.getWatchListsForUser(userBean);
        }
    }

    public List<Movie> getMoviesOfList(Long listId) {
        if(listId==null) {
            return new ArrayList<Movie>();
        }
        else {
            return movieDAO.getMoviesOfList(listId);
        }
    }

    public boolean doesListAlreadyExistForUser(String listName, UserBean userBean) {
        if(listName==null||listName.trim().equals("")||userBean==null) {
            return false;
        }
        else return movieDAO.doesListAlreadyExistForUser(listName,userBean);
    }

    public WatchList getList(String listName, Long userId) {
        if(listName==null||userId==null) {
            return null;
        }
        else {
            return movieDAO.getList(listName,userId);
        }
    }

    public WatchList addComment(CommentBean commentBean) {
        if(commentBean==null) {
            return null;
        }
        else {
            return movieDAO.addComment(commentBean);
        }
    }

    public String deleteList(Long id) {
        if(id==null) {
            return "Invalid input";
        }
        else {
            return movieDAO.deleteList(id);
        }
    }
}
