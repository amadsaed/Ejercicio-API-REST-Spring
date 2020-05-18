package com.example.rest.demo.simplerest.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.rest.demo.simplerest.model.User;
import com.example.rest.demo.simplerest.repository.UserRepository;
import com.example.rest.demo.simplerest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public ResponseEntity<User> create (@Valid @RequestBody User user){
		
		User userCreated= userService.create(user);
		
		return new ResponseEntity<User>(userCreated , HttpStatus.CREATED);
		
	}

	
	@RequestMapping(value ="/users", method = RequestMethod.GET)
	
	public ResponseEntity<User> userList (){
		
		List<User> users= userService.listUser();
		
		return new ResponseEntity(users , HttpStatus.OK);

		
	}
	
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.GET)

	public  ResponseEntity<User> userById(@PathVariable(value="id") long myId){
		User user =userService.get(myId);
		
		return new ResponseEntity(user , HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value ="/user", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody  User user) {
	    	
		user =userService.updateUser(user);
		
		return new ResponseEntity(user , HttpStatus.OK);
	    			 
	    	
	}
	
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {    	
        
		User user= userService.deleteUser(userId);
		
		return new ResponseEntity(user , HttpStatus.OK);
		

    }
	
	
}
