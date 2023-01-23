package com.example.Uptalent.controller;

import java.util.List;

import com.example.Uptalent.config.SecurityUser;
import com.example.Uptalent.dao.UserRepository;
import com.example.Uptalent.exception.CustomException;
import com.example.Uptalent.service.impl.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {   
	    
	    @Autowired
		private UserRepository userRepository;
	    
	    @Autowired
	    private UserServices userservice;

	    @PostMapping("/signup")
	    public String registerUser(@RequestBody SecurityUser user){
	    	return userservice.signup(user);
	    }
	    
	   @GetMapping("/userlist")
	   public List<SecurityUser> listUser() {
		   return userRepository.findAll();
	   }

   
    @PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password) {
    	return userservice.signin(username, password);
	}
   
	
	
	
}
