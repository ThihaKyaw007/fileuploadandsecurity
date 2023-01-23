package com.example.Codetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pay {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@NotNull(message = "Api Caller is require")
		private String api_caller;
		@NotNull(message = "Amount is require")
		private double amount;
		@NotNull(message = "ReferenceNo is require")
		private String reference_no;
		@NotNull(message = "PhoneNumber is require")
		private String phone_number;
		
	
}
