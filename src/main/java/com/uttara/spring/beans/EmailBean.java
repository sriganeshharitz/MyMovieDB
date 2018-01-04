package com.uttara.spring.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmailBean {
    @NotNull
    @NotBlank
    private String emails;
    @NotNull
    @NotBlank
    private String subject;
    @NotNull
    @NotBlank
    private String body;
    private String listName;
    private UserBean userBean;
    private String url;
    public String getEmails() {

        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public EmailBean() {

    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailBean{" +
                "emails='" + emails + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", listName='" + listName + '\'' +
                ", userBean=" + userBean +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailBean emailBean = (EmailBean) o;

        if (emails != null ? !emails.equals(emailBean.emails) : emailBean.emails != null) return false;
        if (subject != null ? !subject.equals(emailBean.subject) : emailBean.subject != null) return false;
        if (body != null ? !body.equals(emailBean.body) : emailBean.body != null) return false;
        if (listName != null ? !listName.equals(emailBean.listName) : emailBean.listName != null) return false;
        if (userBean != null ? !userBean.equals(emailBean.userBean) : emailBean.userBean != null) return false;
        return url != null ? url.equals(emailBean.url) : emailBean.url == null;
    }

    @Override
    public int hashCode() {
        int result = emails != null ? emails.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (listName != null ? listName.hashCode() : 0);
        result = 31 * result + (userBean != null ? userBean.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public UserBean getUserBean() {

        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getListName() {

        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
