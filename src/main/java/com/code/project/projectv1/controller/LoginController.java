package com.code.project.projectv1.controller;

import com.code.project.projectv1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private AuthenticationManager auth;

    @GetMapping("/login")
    public String login(Model theModel){

        theModel.addAttribute("user", new User());
        return "loginTest";
    }

//    @PostMapping("/login")
//    public String pLogin(@ModelAttribute("user") User user){
//
//        System.out.println("Hello");
//        Authentication authentication = auth.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
////        SecurityContextHolder.clearContext();
//        System.out.println(authentication.isAuthenticated());
//        System.out.println("Success");
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return "redirect:/registration/welcomeP";
//
//
////        return "redirect:/loginF";
//
//    }
}
