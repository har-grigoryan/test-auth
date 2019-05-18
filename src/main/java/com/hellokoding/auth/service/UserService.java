package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;

import java.util.Set;

public interface UserService {
    void save(User user);

    void save(User user, Set<Role> roles);

    User findByUsername(String username);
}
