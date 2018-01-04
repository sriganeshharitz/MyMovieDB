package com.uttara.spring.services;

import com.uttara.spring.beans.LoginBean;
import com.uttara.spring.beans.UserBean;
import com.uttara.spring.beans.UserBeanAndMessage;

public interface RegisterService {
    public String register(UserBean userBean);
    public UserBeanAndMessage login(LoginBean loginBean);
}
