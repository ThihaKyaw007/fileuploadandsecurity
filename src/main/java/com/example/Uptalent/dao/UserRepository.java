package com.example.Uptalent.dao;





import com.example.Uptalent.config.SecurityUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<SecurityUser, Integer> {
	boolean existsByUsername(String username);

	  SecurityUser findByUsername(String username);

	  @Transactional
	  void deleteByUsername(String username);
}
