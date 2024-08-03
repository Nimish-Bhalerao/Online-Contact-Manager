package com.ocm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocm.entites.User;
import com.ocm.services.UserService;


@Controller
public class UserController {

      private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

     @RequestMapping(value = "/dashboard", method =
     RequestMethod.GET)
    public String userDashboard() {
        return "user/dashboard";
    }
    
    //user profile page
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile(Model model, Authentication authentication) {
        return "user/profile";
    }
 

    //user add contact page
    //user view contact page
    //user edit contact page
    //user delete contact page
    //user search contact page
}
