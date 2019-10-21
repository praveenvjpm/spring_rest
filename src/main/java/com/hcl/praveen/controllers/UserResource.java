package com.hcl.praveen.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hcl.praveen.dao.UserDAOService;
import com.hcl.praveen.exception.UserNotFoundException;
import com.hcl.praveen.bean.User;

@RestController
public class UserResource {
	@Autowired
	UserDAOService userDAOService;
	
	@GetMapping("/users")
		public List<User> retriveAllusers(){
		return userDAOService.findAll();
	}
	
	
	@GetMapping("/user/{id}")
	public User retriveuser(@PathVariable int id) {
		 User s =userDAOService.findOne(id);
		 if(s == null) {
			 throw new UserNotFoundException("id-"+id);
		 }
		 return s;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		System.out.println("google");
		User s =	userDAOService.save(user); 
		URI u = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(u).build();
		
	}
}
