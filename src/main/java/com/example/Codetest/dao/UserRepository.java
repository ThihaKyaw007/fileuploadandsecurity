package com.example.Codetest.dao;





import com.example.Codetest.config.SecurityUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<SecurityUser, Integer> {
	boolean existsByUsername(String username);

	  SecurityUser findByUsername(String username);

	  @Transactional
	  void deleteByUsername(String username);
}
