package com.example.rest.demo.simplerest.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.demo.simplerest.model.User;
import com.example.rest.demo.simplerest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		 
		return  userRepository.save(user);
		
	}
	
	
	public List<User> listUser() {
		 
	List<User> list = new ArrayList<User>();
	Iterable <User> users = userRepository.findAll();
	users.forEach(list::add); 
	
	//while(users.iterator().hasNext()) {
		//.add(users.iterator().next());
	
	
	
	return list;
	}
	
	
	public User get(long userId) {
		
		return userRepository.findById(userId).orElse(null);
	}
	
	
	
	/*
	public Map<String ,Object> get(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("users",userRepository.findAll().forEach();
                
        return dto;
		
	}
	*/

}
