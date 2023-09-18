package com.code.project.projectv1.service;

import com.code.project.projectv1.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String user);

    boolean isThereSuer(String username);



}
