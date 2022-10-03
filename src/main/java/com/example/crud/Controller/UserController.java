package com.example.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Entity.User;
import com.example.crud.Service.Userservice;

@RestController
public class UserController{
	@ Autowired
	private Userservice userservice;
	
	// method to add single user
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	// method to add multiple users
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users){
		return userservice.createUsers(users);
	}
	
	//GetMapping method for single user
	@GetMapping(value = "/getUser/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userservice.getUserById(id);
	}
	
	// GetMapping method for multiple users
	@GetMapping(value = "/getUsers")
	public List<User> getAllUsers() {
		return userservice.getUsers();
	}
	// delete method
	@DeleteMapping(value = "/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userservice.deleteUserByID(id);
	}
	// update method
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}
}