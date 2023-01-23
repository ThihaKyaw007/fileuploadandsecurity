package com.example.Codetest.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {

	private String status;


	private String message;
	
	private Date date;

	private T responseBody;
}
