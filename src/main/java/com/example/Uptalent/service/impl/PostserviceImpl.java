package com.example.Uptalent.service.impl;

import com.example.Uptalent.dao.PostRepository;
import com.example.Uptalent.model.Post;
import com.example.Uptalent.service.Postinterface;

import org.springframework.beans.factory.annotation.Autowired;

public class PostserviceImpl implements Postinterface {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
	}

}
