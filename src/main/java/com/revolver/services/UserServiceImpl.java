package com.revolver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revolver.entities.User;
import com.revolver.repositories.UserRepository;

@Component
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public User createUser(User user) {
		return ur.save(user);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}

}
