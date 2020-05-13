package com.example.rest.demo.simplerest.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rest.demo.simplerest.model.User;

public interface UserRepository extends CrudRepository<User , Long> {



}