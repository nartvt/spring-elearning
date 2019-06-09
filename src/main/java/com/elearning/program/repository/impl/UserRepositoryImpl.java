package com.elearning.program.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private List<User> users;

  public UserRepositoryImpl() {
    users = new ArrayList<>();
    User user = new User();
    user.setId("T001");
    user.setEmail("tranvantai0011@gmail.com");
    user.setFullname("Tran Van Tai");
    user.setPassword("tranvantai");
    user.setPersonType("CEO");
    user.setAvatar("avatar");
    user.setPhone("01223246232");
    user.setAddress("1 Thanh Loc, Quan 12");
    user.setWebsite("voz.com.vn");
    user.setFacebook("facebook.com");
    user.setRoleId("R01");
    users.add(user);
  }

  @Override
  public List<User> findAll() {
    return this.users;
  }

  @Override
  public User findById(String id) {
    for (User user : users) {
      if (user.getId().equalsIgnoreCase(id)) {
        return user;
      }
    }
    return null;
  }

  @Override
  public boolean save(User user) {    
    return this.users.add(user);
  }

  @Override
  public boolean delete(String id) {
    User user = this.findById(id);
    return users.remove(user);
  }

  @Override
  public boolean update(User user) {
    for(User u:users) {
      if(u.getId().equalsIgnoreCase(user.getId())) {
        u.setEmail(user.getEmail());
        u.setFullname(user.getFullname());
        u.setPassword(user.getPassword());
        u.setPassword(user.getPassword());
        u.setPersonType(user.getPersonType());
        u.setAvatar(user.getAvatar());
        u.setPhone(user.getPhone());
        u.setAddress(user.getAddress());
        u.setWebsite(user.getWebsite());
        u.setFacebook(user.getFacebook());
        u.setRoleId(user.getRoleId());
        return true;
        
      }
    }
    return false;
  }

}
