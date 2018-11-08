package com.example.demoReplay.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoReplay.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	Optional<User> findById( Long id );
	
	User findByEmail(String email);
		
	User findByName( String name );
	
}