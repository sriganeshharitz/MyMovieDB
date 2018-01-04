package com.uttara.spring.beans;

public class UserBeanAndMessage {
    private UserBean userBean;
    private String message;

    public UserBeanAndMessage() {
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserBeanAndMessage{" +
                "userBean=" + userBean +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBeanAndMessage that = (UserBeanAndMessage) o;

        if (userBean != null ? !userBean.equals(that.userBean) : that.userBean != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = userBean != null ? userBean.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public UserBeanAndMessage(UserBean userBean, String message) {
        this.userBean = userBean;
        this.message = message;
    }
}
