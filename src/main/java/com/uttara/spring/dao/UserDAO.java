package com.uttara.spring.dao;

import com.uttara.spring.beans.UserBean;
import com.uttara.spring.beans.UserBeanAndMessage;

public interface UserDAO {
    public String register(UserBean userBean);

    UserBeanAndMessage getUser(String email);
    public boolean isEmailUsed(String email);
}
