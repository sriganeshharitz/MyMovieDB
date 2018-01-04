package com.uttara.spring.dao;

import com.uttara.spring.beans.*;
import com.uttara.spring.constants.Constant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class HSQLMovieDAO implements MovieDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public UserBeanAndMessage createList(UserBean userBean, String name) {
        if(userBean==null||name==null) {
            return new UserBeanAndMessage(null,"Invalid input");
        }
        else {
            WatchList watchList = new WatchList();
            watchList.setName(name);
            watchList.setUserBean(userBean);
            userBean.getWatchListList().add(watchList);
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                session.saveOrUpdate(userBean);
                transaction.commit();
                return new UserBeanAndMessage(userBean, Constant.SUCCESS);
            }
            catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                e.getMessage();
                return new UserBeanAndMessage(null,"Oops something happened contact admin");
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }

    public String addMovieToList(Movie movie, String name) {
        System.out.println("Insided HsqlUser DAO for add movie");
//        System.out.println("movie is "+movie);
        if(movie==null||name==null||name.trim().equals("")) {
            return "Invalid input";
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from WatchList where name = '"+name+"'");
                WatchList watchList= (WatchList) query.getSingleResult();
                watchList.getMovies().add(movie);
                movie.setWatchList(watchList);
                session.save(movie);
                session.saveOrUpdate(watchList);
                transaction.commit();
                return Constant.SUCCESS;
            }
            catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                e.getMessage();
                return "Oops something happened contact admin";
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }

    public List<WatchList> getWatchListsForUser(UserBean userBean) {
        if(userBean==null) {
            return new ArrayList<WatchList>();
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from WatchList where userbean_id = '"+userBean.getId()+"'");
                List<WatchList> watchListForUser=  query.getResultList();
                transaction.commit();
                return watchListForUser;
            }
            catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                e.getMessage();
                return new ArrayList<WatchList>();
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }

    public List<Movie> getMoviesOfList(Long listId) {
        if (listId == null) {
            return new ArrayList<Movie>();
        } else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from Movie where watchlist_id = '" + listId + "'");
                List<Movie> movies = query.getResultList();
                transaction.commit();
                return movies;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                e.getMessage();
                return new ArrayList<Movie>();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        }
    }

    public boolean doesListAlreadyExistForUser(String listName, UserBean userBean) {
        if(listName==null||listName.trim().equals("")||userBean==null) {
            return false;
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from WatchList where name = '"+listName+"'"+"and userbean_id = "+userBean.getId());
                WatchList watchList= (WatchList) query.getSingleResult();
                transaction.commit();
                if(watchList==null) {
                    return false;
                }
                else
                    return true;
            }
            catch (NoResultException e) {
                return false;
            }
            catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                e.getMessage();
                return false;
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }

    public WatchList getList(String listName, Long userId) {
        if(listName==null||userId==null) {
            return null;
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from WatchList where name = '"+listName+"'"+"and userbean_id = "+userId);
                WatchList watchList= (WatchList) query.getSingleResult();
                transaction.commit();
                if(watchList==null) {
                    return null;
                }
                else
                    return watchList;
            }
            catch (NoResultException e) {
                return null;
            }
            catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                e.getMessage();
                return null;
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }

    public WatchList addComment(CommentBean commentBean) {
        if(commentBean==null) {
            return null;
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from WatchList where id = "+commentBean.getWatchListId());
                WatchList watchList= (WatchList) query.getSingleResult();
                if(watchList==null) {
                    return null;
                }
                else {
                    Comment comment = new Comment();
                    comment.setComment(commentBean.getComment());
                    comment.setDate(new Date());
                    comment.setGuest(commentBean.getGuest());
                    comment.setWatchList(watchList);
                    watchList.getComments().add(comment);
                    session.saveOrUpdate(watchList);
                    transaction.commit();
                    return watchList;
                }
            }
            catch (NoResultException e) {
                return null;
            }
            catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                e.getMessage();
                return null;
            }
            finally {
                if(session!=null) {
                    session.close();
                }
            }
        }
    }
}
