package com.elearning.program.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;
import com.elearning.program.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;
  
  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }
  
  

  @Override
  public Role findById(String id) {
    Role role = roleRepository.findById(id);
    return role;
  }

  @Override
  public boolean save(Role role) {
    role.setId(UUID.randomUUID().toString());
   return roleRepository.save(role);
  }

  @Override
  public boolean delete(String id) {
   return roleRepository.delete(id);
  }

  @Override
  public boolean update(Role role) {
   return roleRepository.update(role);
  }

}
