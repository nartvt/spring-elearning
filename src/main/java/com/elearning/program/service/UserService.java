package com.elearning.program.service;

import java.util.List;

import com.elearning.program.entity.User;

public interface UserService {
  List<User> findAll();
  boolean save(User user);
  User findById(String id);
  
  boolean delete(String id);
  boolean update(User user);

}
