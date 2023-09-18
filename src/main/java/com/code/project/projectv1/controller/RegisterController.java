package com.code.project.projectv1.controller;

import com.code.project.projectv1.entity.User;
import com.code.project.projectv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegisterController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder bCrypt;


    @GetMapping(path = "/test")
    public String check(Model theModel){
        theModel.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping(path = "/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult theBinding){

        if (theBinding.hasErrors()) return "registerForm";
        if (service.findByUsername(user.getUsername()) != null) return "redirect:/registration/test";
        user.setId(0);
        user.setPassword(bCrypt.encode(user.getPassword()));
        service.save(user);
        return "redirect:/";
    }
    @GetMapping(path = "/welcomeP")
    public String welcome(Model theModel){
        theModel.addAttribute("user", 123);
        return "welcomePage";
    }

}
