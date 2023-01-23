package com.example.Uptalent.controller;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.example.Uptalent.dao.AttachmentRepository;
import com.example.Uptalent.dao.PostRepository;
import com.example.Uptalent.model.Attachment;
import com.example.Uptalent.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
public class PostController implements ServletContextAware {
	  
	  @Autowired
		private PostRepository postservice;
	  
	  @Autowired
		private AttachmentRepository attrepo;
	  
	  private ServletContext servletContext;
	  private Path path;
	
	  @PostMapping(value="/post",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public  ResponseEntity<String> post(@RequestPart("post")  Post post,@RequestParam("files") MultipartFile[] files){
		 
		  List<Attachment> att1=new ArrayList<Attachment>();
		  for(MultipartFile file: files) {
			  Attachment att=new Attachment();
			  savefiles(file);
			  att.setName(file.getOriginalFilename());
			  att.setPath(path.toString());
			 // attrepo.save(att);
			  att1.add(att);
		  }
		  post.setAttachmentlist(att1);
		  postservice.save(post);
	        return new ResponseEntity<>("Post registered successfully.", HttpStatus.CREATED);
		}

		@GetMapping("/postall")
		public List<Post> getPosts() {
			return postservice.findAll();
		}
private String savefiles(MultipartFile file) {
	try {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddMMyyyHHmmss");
		String newFileName=simpleDateFormat.format(new Date())+file.getOriginalFilename();
		byte[] bytes=file.getBytes();
		 path=Paths.get(this.servletContext.getRealPath("/upload/images/"+newFileName));
		Files.write(path, bytes);
		return newFileName;
	}catch(Exception e) {
		return null;
	}
}

@Override
public void setServletContext(ServletContext servletContext) {
	this.servletContext=servletContext;
	
}
}
