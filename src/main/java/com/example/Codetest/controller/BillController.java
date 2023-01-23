package com.example.Codetest.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.Codetest.dao.BillRepository;
import com.example.Codetest.model.Bill;
import com.example.Codetest.model.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillController {
	
	 @Autowired
		private BillRepository billRepository;
	    

	    @PostMapping("/add")
	    public ResponseDTO<Object> addBill(@RequestBody Bill bill){
	    	Bill addbill=  billRepository.save(bill);
	    	   ResponseDTO<Object> responseDTO = ResponseDTO.builder().status("Successful").message("Bill Topup is successful save in the System!").date(new Date()).responseBody(addbill).build();
			   
			   return responseDTO;
	    }
	   
	   
	   @GetMapping("/billlist")
	   public List<Bill> listBill() {
		   return billRepository.findAll();
	   }
	   
	   @GetMapping("/list/{id}")
	   public ResponseDTO<Object> findById(@PathVariable int id) {
		   Optional<Bill> bill=   billRepository.findById(id);
		   ResponseDTO<Object> responseDTO = ResponseDTO.builder().status("Successful").message("Transation is successful!").date(new Date()).responseBody(bill).build();
	   
		   return responseDTO;
	   }


}
