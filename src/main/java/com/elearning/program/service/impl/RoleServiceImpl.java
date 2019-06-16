package com.elearning.program.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.program.dto.RoleDTO;
import com.elearning.program.entity.Role;
import com.elearning.program.repository.RoleRepository;
import com.elearning.program.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<RoleDTO> findAll() {
		List<Role> roleList = roleRepository.findAll();
		List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
		for (Role role : roleList) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setName(role.getName());
			roleDTO.setDescription(role.getDescription());
			roleDTOList.add(roleDTO);
		}
		return roleDTOList;

	}

	@Override
	public RoleDTO findById(String id) {
		Role role = roleRepository.findById(id);
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(role.getId());
		roleDTO.setName(role.getName());
		roleDTO.setDescription(role.getDescription());
		return roleDTO;
	}

	@Override
	public boolean save(RoleDTO roleDTO) {
		roleDTO.setId(UUID.randomUUID().toString());
		Role role = new Role();
		role.setId(role.getId());
		role.setName(role.getName());
		role.setDescription(role.getDescription());
		return roleRepository.save(role);
	}

	@Override
	public boolean delete(String id) {
		return roleRepository.delete(id);
	}

	@Override
	public boolean update(RoleDTO roleDTO) {
		Role role = new Role();
		role.setId(role.getId());
		role.setName(role.getName());
		role.setDescription(role.getDescription());
		return roleRepository.save(role);
	}

}
