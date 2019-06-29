package com.elearning.program.repository;

import java.util.List;

import com.elearning.program.entity.Role;


public interface RoleRepository extends BaseRepository<Role> {
    List<Role> findRoleNotAdmin();

}
