package com.elearning.program.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * 
   */
  @Autowired
  private SessionFactory sessionFactory;

  private Session session;

  private Session session() {

    try {
      session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = sessionFactory.openSession();
    }

    return session;
  }
  private void closeSession(Session session) {
    if(session!=null) {
      session.flush();
      session.close();
    }
  }

  public UserRepositoryImpl() {

  }

  public List<User> findAll() {
    Session session = this.session();

    try {
      String sqlString = "FROM users";
      Query<User> query = session.createQuery(sqlString, User.class);
      List<User> users = query.getResultList();
      return users;
    } catch (RuntimeException e) {
      this.closeSession(session);
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public User findById(String id) {
    Session session = this.session();
    User user = session.find(User.class, id);
    return user;

  }

  @Override
  public boolean save(User user) {
    Session session = this.session();
    try {
      session.saveOrUpdate(user);
      return true;
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    return false;

  }

  @Override
  public boolean delete(String id) {
    Session session = this.session();
    User user = session.find(User.class, id);

    try {
      session.delete(user);
      return true;
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    return false;
  }

}
