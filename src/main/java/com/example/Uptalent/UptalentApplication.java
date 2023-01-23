package com.example.Uptalent;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Uptalent.config.SecurityUser;
import com.example.Uptalent.model.Role;
import com.example.Uptalent.service.impl.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UptalentApplication implements CommandLineRunner{

	@Autowired
	private UserServices userService;
	
	public static void main(String[] args) {
		SpringApplication.run(UptalentApplication.class, args);
	}

	
	@Override
	public void run(String... params) throws Exception {
		SecurityUser admin = new SecurityUser();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@email.com");
		admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

		userService.signup(admin);

		SecurityUser client = new SecurityUser();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@email.com");
		client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

		userService.signup(client);

	}
}
