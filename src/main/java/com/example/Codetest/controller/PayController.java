package com.example.Codetest.controller;

import java.util.Date;
import java.util.Optional;

import com.example.Codetest.dao.PayRepository;

import com.example.Codetest.model.Pay;
import com.example.Codetest.model.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

	
	 @Autowired
		private PayRepository payRepository;
	    

	    @PostMapping("/pay")
	    public ResponseDTO<Object> addBill(@RequestBody Pay pay){
	    	Pay addpay=  payRepository.save(pay);
	    	   ResponseDTO<Object> responseDTO = ResponseDTO.builder().status("Successful").message("Transation is successful!").date(new Date()).responseBody(addpay).build();
			   
			   return responseDTO;
	    }
	   
	   
	 
	   @GetMapping("/transation/{id}")
	   public ResponseDTO<Object> findById(@PathVariable int id) {
		   Optional<Pay> pay=   payRepository.findById(id);
		   ResponseDTO<Object> responseDTO = ResponseDTO.builder().status("Successful").message("Transation is successful!").date(new Date()).responseBody(pay).build();
	   
		   return responseDTO;
	   }
}
