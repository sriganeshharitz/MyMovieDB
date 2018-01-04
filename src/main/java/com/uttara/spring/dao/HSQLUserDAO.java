package com.uttara.spring.dao;

import com.uttara.spring.beans.UserBean;
import com.uttara.spring.beans.UserBeanAndMessage;
import com.uttara.spring.constants.Constant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class HSQLUserDAO implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public String register(UserBean userBean) {
        if(userBean==null){
            return "Invalid user input";
        }
        else {
           Session session = null;
            Transaction transaction = null;
           try {
               session = sessionFactory.openSession();
               transaction = session.beginTransaction();
               session.save(userBean);
               transaction.commit();
               return Constant.SUCCESS;
           }
           catch (Exception e) {
               transaction.rollback();
               e.printStackTrace();
               e.getMessage();
               return "Oops something happened, contact admin";
           }
           finally {
               if(session!=null) {
                   session.close();
               }
           }
        }
    }

    public UserBeanAndMessage getUser(String email) {
        if(email==null)
            return new UserBeanAndMessage(null,"Invalid input");
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from UserBean where email = '"+email+"'");
                UserBean bean= (UserBean) query.getSingleResult();
//                System.out.println("bean from database = "+bean);
                transaction.commit();
                return new UserBeanAndMessage(bean,Constant.SUCCESS);
            }
            catch (NoResultException e) {
                return new UserBeanAndMessage(null,"Email and password don't match");
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

    public boolean isEmailUsed(String email) {
        if(email==null||email.trim().equals("")) {
            throw new IllegalArgumentException("Cant be null or empty");
        }
        else {
            Session session = null;
            Transaction transaction = null;
            try {
                System.out.println("Inside hsqlDAO");
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                Query query = session.createQuery("from UserBean where email = '"+email+"'");
                UserBean bean= (UserBean) query.getSingleResult();
//                System.out.println("bean from database = "+bean);
                transaction.commit();
                if(bean==null) {
                    return false;
                }
                else
                    return true;
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
}
