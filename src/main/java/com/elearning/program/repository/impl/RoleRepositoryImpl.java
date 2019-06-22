package com.elearning.program.repository.impl;

import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;
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
public class RoleRepositoryImpl implements RoleRepository {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * //   *
     */
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public RoleRepositoryImpl() {
    }

    private Session session() {

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public List<Role> findAll() {
        Session session = this.session();
        try {
            String sql = "FROM roles";
            Query<Role> query = session.createQuery(sql, Role.class);
            List<Role> roles = query.getResultList();
            return roles;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Role findById(String id) {
        Session session = this.session();
        Role role = session.find(Role.class, id);
        return role;
    }

    public boolean save(Role role) {
        Session session = this.session();

        try {
            session.saveOrUpdate(role);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        Session session = this.session();
        Role role = session.find(Role.class, id);

        try {
            session.delete(role);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

}
