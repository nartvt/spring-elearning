package com.elearning.program.service;

import com.elearning.program.dto.RoleDTO;

import java.util.List;

public interface RoleService {
  List<RoleDTO> findAll();

  boolean save(RoleDTO role);

  RoleDTO findById(String id);

  boolean delete(String id);

  boolean update(RoleDTO role);
}
