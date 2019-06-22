package com.elearning.program.repository.impl;

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.google.common.collect.Lists;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
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

    public UserRepositoryImpl() {

    }

    private Session session() {

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public List<User> findAll() {
        Session session = this.session();

        try {
            String sqlString = "FROM users";
            Query<User> query = session.createQuery(sqlString, User.class);
            List<User> users = query.getResultList();
            return users;
        } catch (RuntimeException e) {
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

    @Override
    public User findByEmail(String email) {
        final String sqlString = "FROM users WHERE email:email";
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery(sqlString, User.class);
        query.setParameter("email", email);
        List<User> users = Lists.newArrayList();
        users = query.getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

}
