package com.restfullwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
import com.restfullwebservices.model.UserRepository;
import com.restfullwebservices.service.UserService;

@RestController
public class UserJPAController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll(); 
	}
	
	@GetMapping("/jpa//users/{id}")
	public Resource<User> getFindUser(@PathVariable int id)
	{
			Optional<User> user=userRepository.findById(id);
			if(user==null)
			{
				throw new UserNotFoundException("Id-" + id );
				
			}
			
				Resource<User> resource=new Resource<User>(user.get());
				
				ControllerLinkBuilder linkTo=
				linkTo(methodOn(this.getClass()).getAllUsers());
				resource.add(linkTo.withRel("all-user"));
				return resource;
			
			
			
	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
		
		
	}
	


	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user)
	{
		 
		User savedUser=userRepository.save(user);
				
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/id")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
