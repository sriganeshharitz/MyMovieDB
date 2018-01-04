package com.uttara.spring.beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Proxy(lazy = false)
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 2,max = 30)
    private String firstName;
    @NotNull
    @NotBlank
    @Length(min = 2,max = 30)
    private String lastName;
    @NotNull
    @NotBlank
    @Length(min = 5,max = 30)
    private String email;
    @NotNull
    @NotBlank
    @Length(min = 5,max = 15)
    private String password;
    @NotBlank
    @NotNull
    @Length(min = 5,max = 15)
    private String rpassword;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userBean")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<WatchList> watchListList = new ArrayList<WatchList>();

    public UserBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<WatchList> getWatchListList() {
        return watchListList;
    }

    public void setWatchListList(List<WatchList> watchListList) {
        this.watchListList = watchListList;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean bean = (UserBean) o;

        if (id != null ? !id.equals(bean.id) : bean.id != null) return false;
        if (firstName != null ? !firstName.equals(bean.firstName) : bean.firstName != null) return false;
        if (lastName != null ? !lastName.equals(bean.lastName) : bean.lastName != null) return false;
        if (email != null ? !email.equals(bean.email) : bean.email != null) return false;
        if (password != null ? !password.equals(bean.password) : bean.password != null) return false;
        if (rpassword != null ? !rpassword.equals(bean.rpassword) : bean.rpassword != null) return false;
        return watchListList != null ? watchListList.equals(bean.watchListList) : bean.watchListList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rpassword != null ? rpassword.hashCode() : 0);
        result = 31 * result + (watchListList != null ? watchListList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "";
    }
}
