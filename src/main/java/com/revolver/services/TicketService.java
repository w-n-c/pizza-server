package com.revolver.services;


import com.revolver.entities.Ticket;

/*
And	findByLastnameAndFirstname	… where x.lastname = ?1 and x.firstname = ?2
Or	findByLastnameOrFirstname	… where x.lastname = ?1 or x.firstname = ?2
 */

public interface TicketService {
	
	Ticket createTicket(Ticket ticket);

}
