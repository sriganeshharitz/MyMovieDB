package com.uttara.spring.beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Proxy(lazy = false)
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UserBean userBean;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "watchList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movie> movies = new ArrayList<Movie>();
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "watchList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments = new ArrayList<Comment>();

    public WatchList(UserBean userBean) {
        this.userBean = userBean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchList watchList = (WatchList) o;

        if (id != null ? !id.equals(watchList.id) : watchList.id != null) return false;
        if (userBean != null ? !userBean.equals(watchList.userBean) : watchList.userBean != null) return false;
        if (movies != null ? !movies.equals(watchList.movies) : watchList.movies != null) return false;
        if (name != null ? !name.equals(watchList.name) : watchList.name != null) return false;
        return comments != null ? comments.equals(watchList.comments) : watchList.comments == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userBean != null ? userBean.hashCode() : 0);
        result = 31 * result + (movies != null ? movies.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "";
    }

    public WatchList() {
    }
}
