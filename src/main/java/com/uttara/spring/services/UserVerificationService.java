package com.uttara.spring.services;

import com.uttara.spring.beans.UserBean;

public interface UserVerificationService {
    public String isValidUser(UserBean userBean);
}
