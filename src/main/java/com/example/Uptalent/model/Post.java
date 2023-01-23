package com.example.Uptalent.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String skills;

	@ManyToOne
	@JoinColumn(name = "t_id", referencedColumnName = "id", nullable = false)
	private TalentCategory category;
	private String post_Description; 
	private int phone;
	private String gender;
	private Date apply_Date;
	private String address;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "postid", referencedColumnName = "ID")
	private List<Attachment> attachmentlist;
	
	
	
	  
	
	
	
	

}
