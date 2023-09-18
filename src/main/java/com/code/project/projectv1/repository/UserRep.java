package com.code.project.projectv1.repository;

import com.code.project.projectv1.entity.User;

public interface UserRep {
    void save(User user);
    User findByUsername(String userName);
    int checkUserName(String userName);
    Long userCount(String userName);

}
