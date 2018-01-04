package com.uttara.spring.services;

import com.uttara.spring.beans.EmailBean;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
    public String createUrl(EmailBean emailBean) {
        if(emailBean==null) {
            return null;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://localhost:8080/viewList?listName=");
            stringBuilder.append(emailBean.getListName());
            stringBuilder.append("&user=");
            stringBuilder.append(emailBean.getUserBean().getId());
            return stringBuilder.toString();
        }
    }
}
