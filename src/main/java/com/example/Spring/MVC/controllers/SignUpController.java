package com.example.Spring.MVC.controllers;

import com.example.Spring.MVC.model.User;
import com.example.Spring.MVC.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUp(@ModelAttribute("UserFormData")User userForm){

        return "signUp";

    }

    @PostMapping("/signup")
    public String register(@ModelAttribute("UserFormData")User userForm,Model model){
        String signUpError = null;

        if(!userService.isUserAvaliable(userForm.getUsername())){
            signUpError = "Username not avaliable, please choose another username";
        }else{
            int userCreate = userService.createUser(userForm);
            if(userCreate < 0){
                signUpError = "Opps..Something went Wrong please try again!";
            }
        }

        if(signUpError == null){
            model.addAttribute("SignUpSuccess",true);
        }else{
            model.addAttribute("SignUpErrorMessage",signUpError);
        }

        return "signup";
    }


}
