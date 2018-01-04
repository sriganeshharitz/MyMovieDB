package com.uttara.spring.services;

import com.uttara.spring.beans.UserBean;
import com.uttara.spring.constants.Constant;
import com.uttara.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVerificationServiceImpl implements UserVerificationService {
    @Autowired
    private UserDAO userDAO;
    public String isValidUser(UserBean userBean) {
        if(userBean==null) {
            return "Invalid Input, bean is null";
        }
        else {
            if(!userBean.getPassword().equals(userBean.getRpassword())) {
                return "Passwords don't match";
            }
            else {
                if(userDAO.isEmailUsed(userBean.getEmail())) {
                    return "Email already in use.";
                }
                else {
                    return Constant.SUCCESS;
                }
            }
        }
    }
}
