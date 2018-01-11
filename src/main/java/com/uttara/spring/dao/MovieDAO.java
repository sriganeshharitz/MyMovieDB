package com.uttara.spring.dao;

import com.uttara.spring.beans.*;

import java.util.List;

public interface MovieDAO {
    UserBeanAndMessage createList(UserBean userBean, String name);


    String addMovieToList(Movie movie, String name);

    List<WatchList> getWatchListsForUser(UserBean userBean);

    List<Movie> getMoviesOfList(Long listId);

    boolean doesListAlreadyExistForUser(String listName, UserBean userBean);

    WatchList getList(String listName, Long userId);

    WatchList addComment(CommentBean commentBean);

    String deleteList(Long id);
}
