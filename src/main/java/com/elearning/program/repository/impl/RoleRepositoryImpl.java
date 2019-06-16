package com.elearning.program.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;

//  private List<Role> roles;
//
//  public RoleRepositoryImpl() {
//    roles = new ArrayList<Role>();
//    Role  role = new Role();
//    role.setId("R01");
//    role.setName("CEO");
//    role.setDescription("CEO of Software Company");
//    
//    Role  role2 = new Role();
//    role2.setId("R02");
//    role2.setName("CEO");
//    role2.setDescription("CEO of Software Company");
//    
//    roles.add(role);
//    roles.add(role2);
//  }

	@Override
	public List<Role> findAll() {
		System.out.println("Begin Query All");
		
		Session session = null;
		try {
			// Step-2: Implementation
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// Step-3: Implementation
			session = sessionFactory.openSession();
		}
		String sql = "FROM roles";
		Query<Role> query = session.createQuery(sql, Role.class);
		System.out.println(query.toString());
		List<Role> roles = query.getResultList();
		return roles;

	}

	@Override
	public Role findById(String id) {
		Session session = null;
		try {
			// Step-2: Implementation
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// Step-3: Implementation
			session = sessionFactory.openSession();
		}
		Role role = session.find(Role.class, id);
		// session.getTransaction().commit();
		session.flush();
		session.close();
		return role;
	}

	@Override
	public boolean save(Role role) {
		Session session = null;
		try {
			// Step-2: Implementation
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// Step-3: Implementation
			session = sessionFactory.openSession();
		}

		try {
			session.beginTransaction();
			session.saveOrUpdate(role);
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

	@Override
	public boolean delete(String id) {
		Session session = null;
		try {
			// Step-2: Implementation
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// Step-3: Implementation
			session = sessionFactory.openSession();
		}
		Role role = session.find(Role.class, id);

		try {
			session.beginTransaction();
			session.delete(role);
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

//  @Override
//  public boolean update(Role role) {
//    for (Role r : roles) {
//      if (r.getId().equalsIgnoreCase(role.getId())) {
//        r.setName(role.getName());
//        r.setDescription(role.getDescription());
//        return true;
//      }
//    }
//    return true;
//  }

}
