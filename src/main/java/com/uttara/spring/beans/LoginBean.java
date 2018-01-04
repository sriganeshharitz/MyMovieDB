package com.uttara.spring.beans;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginBean {
    @NotBlank
    @NotNull
    @Length(min = 5,max = 30)
    private String email;
    @NotBlank
    @NotNull
    @Length(min = 5,max = 15)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginBean loginBean = (LoginBean) o;

        if (email != null ? !email.equals(loginBean.email) : loginBean.email != null) return false;
        return password != null ? password.equals(loginBean.password) : loginBean.password == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginBean(@NotBlank @NotNull String email, @NotBlank @NotNull String password) {

        this.email = email;
        this.password = password;
    }

    public LoginBean() {

    }
}
