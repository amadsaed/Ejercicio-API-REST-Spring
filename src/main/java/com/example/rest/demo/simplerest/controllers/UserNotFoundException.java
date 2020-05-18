package com.example.rest.demo.simplerest.controllers;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (Long id) {    
    	
        super("User with ID: " + id+ " not exist");
        
    	System.out.println("User with ID: " + id+ " not exist");
    }
}
