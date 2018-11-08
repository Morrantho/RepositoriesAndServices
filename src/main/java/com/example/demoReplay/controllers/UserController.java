package com.example.demoReplay.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.demoReplay.models.User;
import com.example.demoReplay.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService uS) {
		userService = uS;
	}
	
    @GetMapping("")
	public String root( Model model ) {
        model.addAttribute("user", new User() );
		model.addAttribute("users",userService.findAll());
        
		return "users";
	}

    @PostMapping("")
    public String register( @Valid @ModelAttribute("user") User user, BindingResult postData ){
        if( postData.hasErrors() ) return "users";
//    	MAKE A QUERY TO SAVE THIS USER
        userService.create(user);
    	return "redirect:/users";
    }
}
