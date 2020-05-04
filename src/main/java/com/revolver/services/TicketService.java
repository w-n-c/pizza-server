package com.revolver.services;


import java.util.ArrayList;
import java.util.Set;
 

import com.revolver.entities.Ticket;

public interface TicketService {
	
	Ticket createTicket(Ticket ticket);

	Set<Ticket> findTicketByUsername(String username);
	
	Set<Ticket> getAllTicketsByUsername(String username);
	
	ArrayList<Ticket> getAllTicketsByUsername();

}
