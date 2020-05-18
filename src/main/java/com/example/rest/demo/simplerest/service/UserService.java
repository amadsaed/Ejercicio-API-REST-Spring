package com.example.rest.demo.simplerest.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.rest.demo.simplerest.controllers.UserNotFoundException;
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
		
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}
	
	

    public User updateUser (User user) {
    	
    	 return userRepository.save(user);
    			 
    	
    }
    
    
    
    public User deleteUser( Long userId) { 
    	
    	User user = userRepository.findById(userId)
                .map( userFounded -> {
                	userRepository.deleteById(userId);
                    return userFounded;
                })
                
                .orElseThrow(() -> new UserNotFoundException(userId));
    	
    	return user;

    }

	/*
	public Map<String ,Object> get(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("users",userRepository.findAll().forEach();
                
        return dto;
		
	}
	*/

}
