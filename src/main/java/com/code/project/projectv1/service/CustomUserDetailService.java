package com.code.project.projectv1.service;

import com.code.project.projectv1.entity.User;
import com.code.project.projectv1.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRep userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(userName + " Hello");
//        int num = userDao.checkUserName(userName);
        User user = userDao.findByUsername(userName);
        System.out.println("At load user: "  + user.getRole().get(0));
        if(user == null){
            System.out.println("Can't find your account");
            throw new UsernameNotFoundException("Can't find your account");
        }

        System.out.println(user);


        return new CustomUserDetail(user);
    }
}
