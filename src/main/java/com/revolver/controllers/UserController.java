package com.revolver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revolver.entities.User;
import com.revolver.services.UserService;

@Component
@Controller
@CrossOrigin
public class UserController {
	@Autowired 
	UserService us;
	
	@PostMapping("/users/")
	@ResponseBody
	@CrossOrigin
	public User getUserByUsernameAndPassword(@RequestBody User user) {
		User result = us.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return result;
	}
	
	@ResponseBody
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return us.createUser(user);
	}
	
}
