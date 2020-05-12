package com.revolver.services;

import java.util.Set;

import org.springframework.data.domain.Slice;

import com.revolver.entities.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

	Set<Ticket> findTicketByUsername(String username);

	Set<Ticket> findAllTickets();
	
	Slice<Ticket> findByPage(int page);
	
	Ticket updateTicketStatus(Ticket ticket);

}
