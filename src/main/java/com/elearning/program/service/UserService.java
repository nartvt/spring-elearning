package com.elearning.program.service;

import java.util.List;

import com.elearning.program.dto.UserDTO;

public interface UserService {
  List<UserDTO> findAll();
  boolean save(UserDTO user);
  UserDTO findById(String id);
  
  boolean delete(String id);
  boolean update(UserDTO user);

}
