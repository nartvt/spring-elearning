package com.elearning.program.service;

import java.util.List;

import com.elearning.program.dto.RoleDTO;
import com.elearning.program.entity.Role;

public interface RoleService {
  List<RoleDTO> findAll();
  boolean save(RoleDTO role);
  RoleDTO findById(String id);
  
  boolean delete(String id);
  boolean update(RoleDTO role);
}
