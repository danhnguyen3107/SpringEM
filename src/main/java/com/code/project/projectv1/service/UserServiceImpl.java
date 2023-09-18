package com.code.project.projectv1.service;

import com.code.project.projectv1.entity.Role;
import com.code.project.projectv1.entity.User;
import com.code.project.projectv1.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRep userRep;
    @Override
    public void save(User user) {
        Role r = new Role();
        r.setRole("Employee");
        user.setRole(Arrays.asList(r));
        userRep.save(user);
    }

    @Override
    public User findByUsername(String user) {
        return userRep.findByUsername(user);
    }

    @Override
    public boolean isThereSuer(String username) {
        return userRep.userCount(username) > 0;
    }


}
