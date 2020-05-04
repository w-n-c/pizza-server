package com.revolver.services;

import com.revolver.entities.User;
import com.revolver.entities.Ticket;

import java.util.ArrayList;
import java.util.Set;


public interface UserService {
	
	User createUser(User user);
	
	User getUserByUsernameAndPassword(String username, String password);
	
	
	//Returns a sorted list of Ticket by placement
	ArrayList<Ticket> getAllTicketByUsername(String username);
	
	
	ArrayList<Ticket> getAllTicketByUsername(Integer id);
	
	

	
	
}
