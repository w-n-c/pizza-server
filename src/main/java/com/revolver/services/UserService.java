package com.revolver.services;

import com.revolver.entities.User;


public interface UserService {
	
	User createUser(User user);
	
	User getUserByUsernameAndPassword(String username, String password);
	
}
