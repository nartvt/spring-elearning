package com.elearning.program.repository;

import com.elearning.program.entity.User;

public interface UserRepository extends BaseRepository<User> {
    User findByEmail(String email);

}
