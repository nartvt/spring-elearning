package com.elearning.program.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.elearning.program.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public boolean save(User user) {
    user.setId(UUID.randomUUID().toString());
    return this.userRepository.save(user);
  }

  @Override
  public User findById(String id) {
    return this.userRepository.findById(id);
  }

  @Override
  public boolean delete(String id) {
   return userRepository.delete(id);
  }

  @Override
  public boolean update(User user) {
    return userRepository.update(user);
  }

}
