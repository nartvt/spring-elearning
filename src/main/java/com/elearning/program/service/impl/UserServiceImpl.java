package com.elearning.program.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.program.dto.UserDTO;
import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.elearning.program.service.UserService;



@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserDTO> findAll() {
    List<User> userList = userRepository.findAll();
    List<UserDTO> userDTOs = new ArrayList<UserDTO>();   
    userList.forEach(user -> {
      UserDTO userDTO = new UserDTO();
      this.transferDataUserDTO(userDTO, user);
      userDTOs.add(userDTO);
    });

    return userDTOs;
  }
  public boolean save(UserDTO userDTO) {
    userDTO.setUserId(UUID.randomUUID().toString());
    User user = new User();
    this.transferDataUser(user, userDTO);
    return this.userRepository.save(user);
  }

  private void transferDataUser(User user, UserDTO userDTO) {
    
    
    user.setUserId(userDTO.getUserId());
    user.setFullname(userDTO.getFullname());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    user.setPersonType(userDTO.getPersonType());
    user.setAvatar(userDTO.getAvatar());
    user.setPhone(userDTO.getPhone());
    user.setAddress(userDTO.getAddress());
    user.setWebsite(userDTO.getWebsite());
    user.setFacebook(userDTO.getFacebook());
    user.setRoleId(userDTO.getRoleId());
    
  }

  private void transferDataUserDTO(UserDTO userDTO, User user) {
    
    userDTO.setUserId(user.getRoleId());
    userDTO.setFullname(user.getFullname());
    userDTO.setEmail(user.getEmail());
    userDTO.setPassword(user.getPassword());
    userDTO.setPersonType(user.getPersonType());
    userDTO.setAvatar(user.getAvatar());
    userDTO.setPhone(user.getPhone());
    userDTO.setAddress(user.getAddress());
    userDTO.setWebsite(user.getWebsite());
    userDTO.setFacebook(user.getFacebook());
    userDTO.setRoleId(user.getRoleId());
  }
  public UserDTO findById(String id) {
    User user = this.userRepository.findById(id);
    UserDTO userDTO = new UserDTO();
    this.transferDataUserDTO(userDTO, user);
    return userDTO;
  }
  public boolean delete(String id) {
    return userRepository.delete(id);
  }
  public boolean update(UserDTO user) {
    User u = userRepository.findById(user.getUserId());
    if (u != null) {
      u.setEmail(user.getEmail());
      u.setFullname(user.getFullname());
      u.setPassword(user.getPassword());
      u.setPersonType(user.getPersonType());
      u.setAvatar(user.getAvatar());
      u.setPhone(user.getPhone());
      u.setAddress(user.getAddress());
      u.setWebsite(user.getWebsite());
      u.setFacebook(user.getFacebook());
      u.setRoleId(user.getRoleId());
    }
    return userRepository.save(u);
  }

}
