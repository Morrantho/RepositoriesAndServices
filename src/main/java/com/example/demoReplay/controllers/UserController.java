package com.example.demoReplay.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String root( Model model, HttpSession session ) {
        model.addAttribute("user", new User() );
		model.addAttribute("users",userService.findAll());
        session.invalidate();
		return "users";
	}

    @GetMapping("/dashboard")
    public String dashboard( HttpSession session, Model model ) {
    	Long userId = (Long) session.getAttribute("user");
    	if( userId == null ) return "redirect:/users";
    	User user = userService.findById( userId );
    	model.addAttribute("userData",user);
    	model.addAttribute("posts", user.getPosts() );
    	
    	
    	return "dashboard";
    }
    
    @PostMapping("")
    public String register( @Valid @ModelAttribute("user") User user, BindingResult postData, Model model, HttpSession session ){
        if( postData.hasErrors() ) return "users";

        if( userService.findByEmail( user.getEmail() ) != null ) {
        	model.addAttribute( "exists", "A user with this email already exists!" );
            model.addAttribute("user", new User() );
    		model.addAttribute("users",userService.findAll());        	
        	return "users";
        }
        
        if( !user.getPassword().equals( user.getConfirm() ) ) {
        	model.addAttribute( "regError", "Password and Password Confirmation must match!" );
            model.addAttribute("user", new User() );
    		model.addAttribute("users",userService.findAll());        	
        	return "users";        
        }
        
        userService.create(user);
    	session.setAttribute( "user" , user.getId() );
        return "redirect:/users/dashboard";
    }

    @PostMapping("/login")
    public String login( HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password, Model model ) {
    	
    	User user = userService.findByEmail(email);
    	
    	if( user == null ) { 
    		model.addAttribute("loginError","Invalid Credentials");
            model.addAttribute("user", new User() );
    		model.addAttribute("users",userService.findAll());    		
    		return "users";
    	}
    	if( !user.getPassword().equals( password ) ) { 
    		model.addAttribute("loginError2","Invalid Credentials");
            model.addAttribute("user", new User() );
    		model.addAttribute("users",userService.findAll());    		
    		return "users";
    	}
    	
    	session.setAttribute( "user", user.getId() );
    	return "redirect:/users/dashboard";
    }
    
    @PostMapping("/update")
    public String update( @Valid @ModelAttribute("user") User user, BindingResult postData){
        if( postData.hasErrors() ) return "users";
         
        userService.update(user);
    	return "redirect:/users";
    }
    
    @GetMapping("/{userId}")
    public String findById( @PathVariable("userId") Long userId, Model model ) {
    	User user = userService.findById( userId );    	
    	if(user == null) { return "redirect:/users"; }
    	model.addAttribute("user",user);
    	return "show";
    }
    
    @PostMapping("/{userId}/destroy")
    public String destroy( @PathVariable("userId") Long userId ){
    	userService.destroy(userId);
    	return "redirect:/users";
    }
}
