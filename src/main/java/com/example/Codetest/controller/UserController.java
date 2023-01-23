package com.example.Codetest.controller;

import java.util.List;

import com.example.Codetest.config.SecurityUser;
import com.example.Codetest.dao.UserRepository;
import com.example.Codetest.impl.UserServices;
import com.example.Codetest.model.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
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
	public ResponseDTO<Object> login(@RequestParam String username,@RequestParam String password) {
    	String token=userservice.signin(username, password);
    	 ResponseDTO<Object> responseDTO = ResponseDTO.builder().status("Successful").message("Login is successful!").responseBody(token).build();
  	   
  	   return responseDTO;
	}
   
	  
	
	
}
