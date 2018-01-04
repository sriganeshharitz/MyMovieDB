package com.uttara.spring.services;

import com.uttara.spring.beans.EmailBean;

public interface EmailService {
    public String sendEmail(EmailBean emailBean);
}
