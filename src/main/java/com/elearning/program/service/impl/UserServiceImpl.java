package com.elearning.program.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.program.dto.UserDTO;
import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;
import com.elearning.program.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> findAll() {
		List<User> userList = userRepository.findAll();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		userList.stream().forEach(user -> {
			UserDTO userDTO = new UserDTO();
			this.transferDataUserDTO(userDTO, user);
		});
		return userDTOs;
	}

	@Override
	public boolean save(UserDTO userDTO) {
		userDTO.setId(UUID.randomUUID().toString());
		User user = new User();
		this.transferDataUser(user, userDTO);
		return this.userRepository.save(user);
	}

	private void transferDataUser(User user, UserDTO userDTO) {
		user.setId(userDTO.getId());
		user.setFullname(userDTO.getFullname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPersonType(userDTO.getPersonType());
		user.setAvatar(userDTO.getAvatar());
		user.setPhone(userDTO.getPhone());
		user.setAddress(userDTO.getAddress());
		user.setWebsite(userDTO.getWebsite());
		user.setFacebook(userDTO.getFacebook());
	}

	private void transferDataUserDTO(UserDTO userDTO, User user) {
		userDTO.setId(userDTO.getId());
		userDTO.setFullname(userDTO.getFullname());
		userDTO.setEmail(userDTO.getEmail());
		userDTO.setPassword(userDTO.getPassword());
		userDTO.setPersonType(userDTO.getPersonType());
		userDTO.setAvatar(userDTO.getAvatar());
		userDTO.setPhone(userDTO.getPhone());
		userDTO.setAddress(userDTO.getAddress());
		userDTO.setWebsite(userDTO.getWebsite());
		userDTO.setFacebook(userDTO.getFacebook());
	}

	@Override
	public UserDTO findById(String id) {
		User user = this.userRepository.findById(id);
		UserDTO userDTO = new UserDTO();
		this.transferDataUserDTO(userDTO,user );
		return userDTO;
	}

	@Override
	public boolean delete(String id) {
		return userRepository.delete(id);
	}

	@Override
	public boolean update(UserDTO user) {
		User u = userRepository.findById(user.getId());
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
