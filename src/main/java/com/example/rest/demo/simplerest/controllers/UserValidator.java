package com.example.rest.demo.simplerest.controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;

import com.example.rest.demo.simplerest.model.User;

public class UserValidator implements Validator {

   
    public boolean supports(Class clazz) {
      return User.class.equals(clazz);
    }

    
    public void validate(Object target, Errors errors) {
      User user = (User) target;

      if(user.getUserName()== null) {
          errors.rejectValue("Username", "your_error_code");
      }

      // do "complex" validation here

    }


	@Override
	public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value,
			Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T unwrap(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ExecutableValidator forExecutables() {
		// TODO Auto-generated method stub
		return null;
	}

}
