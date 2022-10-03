package com.example.crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Entity.User;
import com.example.crud.Repository.UserRepository;


@Service
public class Userservice {
@Autowired
private UserRepository userRepository;
 // method for single and multiple users
public User createUser(User user) {
	//System.out.println("user"+user.getName());
	return userRepository.save(user);
}
public List<User> createUsers(List<User> users){
	return userRepository.saveAll(users);
}

  // Get method for single and multiple users
 public <Option>User getUserById (int id) {
	 return userRepository.findById(id).orElseThrow();
 }
 public List<User> getUsers(){
	 return userRepository.findAll();
 }
 
 // Update method
   public User updateUser(User user) {
	 User oldUser = null;
	 Optional<User>optionalUser = userRepository.findById(user.getId());
	 if (optionalUser.isPresent()) {
		 oldUser = optionalUser.get();
		 oldUser.setName(user.getName());
	 oldUser.setAddress(user.getAddress());
		 oldUser.setEmail(user.getEmail());
		 userRepository.save(oldUser);
	 }
	 else {
		 return new User();
	 }
	 return oldUser;
	 }

 // Delete method
   public String deleteUserByID(int id) {
	   userRepository.deleteById(id);
	   return " USER GOT DELETED"; 
	   }
}