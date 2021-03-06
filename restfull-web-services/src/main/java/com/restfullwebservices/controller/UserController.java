package com.restfullwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfullwebservices.exception.UserNotFoundException;
import com.restfullwebservices.model.User;
import com.restfullwebservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userservice.findAll(); 
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getFindUser(@PathVariable int id)
	{
			User user=userservice.findUser(id);
			if(user==null)
			{
				throw new UserNotFoundException("Id-" + id );
				
			}
			
				Resource<User> resource=new Resource<User>(user);
				
				ControllerLinkBuilder linkTo=
				linkTo(methodOn(this.getClass()).getAllUsers());
				resource.add(linkTo.withRel("all-user"));
				return resource;
			
			
			
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user=userservice.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("Id-" + id );
		
	}
	


	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user)
	{
		 
		User savedUser=userservice.saveUser(user);
				
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/id")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
