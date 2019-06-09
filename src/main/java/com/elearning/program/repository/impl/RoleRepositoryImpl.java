package com.elearning.program.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  private List<Role> roles;

  public RoleRepositoryImpl() {
    roles = new ArrayList<Role>();
    Role  role = new Role();
    role.setId("R01");
    role.setName("CEO");
    role.setDescription("CEO of Software Company");
    
    Role  role2 = new Role();
    role2.setId("R02");
    role2.setName("CEO");
    role2.setDescription("CEO of Software Company");
    
    roles.add(role);
    roles.add(role2);
  }

  @Override
  public List<Role> findAll() {
   
    return this.roles;
  }

  @Override
  public Role findById(String id) {
    for (Role role : roles) {
      if (role.getId().equalsIgnoreCase(id)) {
        return role;
      }
    }
    return null;
  }

  @Override
  public boolean save(Role role) {
    return this.roles.add(role);
  }

  @Override
  public boolean delete(String id) {
    Role role = this.findById(id);
    return this.roles.remove(role);
  }

  @Override
  public boolean update(Role role) {
    for (Role r : roles) {
      if (r.getId().equalsIgnoreCase(role.getId())) {
        r.setName(role.getName());
        r.setDescription(role.getDescription());
        return true;
      }
    }
    return true;
  }

}
