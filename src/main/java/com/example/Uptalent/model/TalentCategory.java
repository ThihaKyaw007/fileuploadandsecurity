package com.example.Uptalent.model;


import javax.persistence.Entity;
import javax.persistence.Id;


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
public class TalentCategory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String type;
	private String name;
	private String status;



	

}
