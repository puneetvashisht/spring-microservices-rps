package com.fis.authservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fis.authservice.entity.User;



@EnableJpaRepositories
public interface UserRepo  extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);

}
