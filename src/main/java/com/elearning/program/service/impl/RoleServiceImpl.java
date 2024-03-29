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

  public List<RoleDTO> findAll() {
    List<Role> roleList = roleRepository.findAll();
    List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
    for (Role role : roleList) {
      RoleDTO roleDTO = new RoleDTO();
      roleDTO.setRoleId(role.getRoleId());
      roleDTO.setName(role.getName());
      roleDTO.setDescription(role.getDescription());
      roleDTOList.add(roleDTO);
    }
    return roleDTOList;

  }

  public RoleDTO findById(String id) {
    Role role = roleRepository.findById(id);
    RoleDTO roleDTO = new RoleDTO();
    roleDTO.setRoleId(role.getRoleId());
    roleDTO.setName(role.getName());
    roleDTO.setDescription(role.getDescription());
    return roleDTO;
  }

  public boolean save(RoleDTO roleDTO) {
    roleDTO.setRoleId(UUID.randomUUID().toString());
    Role role = new Role();
    role.setId(roleDTO.getRoleId());
    role.setName(roleDTO.getName());
    role.setDescription(roleDTO.getDescription());
    return roleRepository.save(role);
  }

  public boolean delete(String id) {
    return roleRepository.delete(id);
  }

  public boolean update(RoleDTO roleDTO) {
    Role role = new Role();
    role.setId(role.getRoleId());
    role.setName(role.getName());
    role.setDescription(role.getDescription());
    return roleRepository.save(role);
  }

  @Override
  public List<RoleDTO> findNotAdmin() {
    List<Role> roleList = roleRepository.findRoleNotAdmin();
    List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
    for (Role role : roleList) {
      RoleDTO roleDTO = new RoleDTO();
      roleDTO.setRoleId(role.getRoleId());
      roleDTO.setName(role.getName());
      roleDTO.setDescription(role.getDescription());
      roleDTOList.add(roleDTO);
    }
    return roleDTOList;

  }

}
