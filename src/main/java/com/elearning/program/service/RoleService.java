package com.elearning.program.service;

import java.util.List;

import com.elearning.program.entity.Role;

public interface RoleService {
  List<Role> findAll();
  boolean save(Role role);
  Role findById(String id);
  
  boolean delete(String id);
  boolean update(Role role);
}
