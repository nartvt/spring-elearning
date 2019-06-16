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
	@Autowired
	private SessionFactory sessionFactory;

 


	public UserRepositoryImpl() {
	 
	}

	@Override
	public List<User> findAll() {
		Session session=null;
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		try {
//			 session.beginTransaction();
			Query<User> query = session.createQuery("FROM users", User.class);
//			 session.getTransaction().commit();
			List<User> users = query.getResultList();
			 session.flush();
			 session.close();
			return users;
		} catch (RuntimeException e) {
//			 session.getTransaction().rollback();
			e.printStackTrace();
		}
//		finally {
//			session.flush();
//			session.close();
//		}
		return null;
	}

	@Override
	public User findById(String id) {
		Session session=null;
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		User user = session.find(User.class, id);
		// session.getTransaction().commit();
		return user;
//		for (User user : users) {
//			if (user.getId().equalsIgnoreCase(id)) {
//				return user;
//			}
//		}
//		return null;
	}

	@Override
	public boolean save(User user) {
		Session session=null;
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}

		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} 
		finally {
			session.flush();
			session.close();
		}
		return false;
		
	}

	@Override
	public boolean delete(String id) {
		Session session=null;
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		User user = session.find(User.class,id);

		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

//	@Override
//	public boolean update(User user) {
//		for (User u : users) {
//			if (u.getId().equalsIgnoreCase(user.getId())) {
//				u.setEmail(user.getEmail());
//				u.setFullname(user.getFullname());
//				u.setPassword(user.getPassword());
//				u.setPassword(user.getPassword());
//				u.setPersonType(user.getPersonType());
//				u.setAvatar(user.getAvatar());
//				u.setPhone(user.getPhone());
//				u.setAddress(user.getAddress());
//				u.setWebsite(user.getWebsite());
//				u.setFacebook(user.getFacebook());
//				u.setRoleId(user.getRoleId());
//				return true;
//
//			}
//		}
//		return false;
//	}

}
