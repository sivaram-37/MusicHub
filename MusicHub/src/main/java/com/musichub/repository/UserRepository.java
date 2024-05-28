package com.musichub.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.musichub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	


	

	
}
