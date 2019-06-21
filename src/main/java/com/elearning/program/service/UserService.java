package com.elearning.program.service;

import com.elearning.program.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    boolean save(UserDTO user);

    UserDTO findById(String id);

    boolean delete(String id);

    boolean update(UserDTO user);

}
