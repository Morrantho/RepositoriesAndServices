package com.example.demoReplay.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoReplay.models.User;
import com.example.demoReplay.repositories.UserRepository;

@Service
public class UserService{

	private UserRepository userRepository;

	public UserService( UserRepository uR ){
		userRepository = uR;
	}
	
	public User create( User user ) {
		return userRepository.save( user );
	}
	
	public ArrayList<User> findAll(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if( user.isPresent() ) return user.get();
		return null;
	}
	
	public User findByEmail( String email ) {
		return userRepository.findByEmail(email);
	}
	
	public User update( User user ) {
		return userRepository.save( user );
	}
	
	public void destroy( User user ) {
		userRepository.delete( user );
	}
	
	public void destroy(Long id) {
		userRepository.deleteById(id);
	}
}
