package com.uttara.spring.services;

import com.uttara.spring.beans.LoginBean;
import com.uttara.spring.beans.UserBean;
import com.uttara.spring.beans.UserBeanAndMessage;
import com.uttara.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDAO userDAO;
    public String register(UserBean userBean) {
        if(userBean==null)
            return "invalid input";
        else {
            return userDAO.register(userBean);
        }
    }

    public UserBeanAndMessage login(LoginBean userBean) {
        System.out.println("Inside Register service");
        if(userBean==null){
            return new UserBeanAndMessage(null,"Invalid Input");
        }

        else {
//            System.out.println("LoginBean is "+userBean);
            UserBeanAndMessage beanFromDAO = userDAO.getUser(userBean.getEmail());
            if(beanFromDAO.getUserBean()==null){
                System.out.println("Inside if bean from dao == null");
                return beanFromDAO;
            }
            else {
                if(beanFromDAO.getUserBean().getPassword().equals(userBean.getPassword())) {
                    System.out.println("Inside if email and passwords match");
                    return beanFromDAO;
                }
                else
                    return new UserBeanAndMessage(null,"Email and Password don't match");
            }
        }
    }
}
