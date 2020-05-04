package com.revolver.services;

import com.revolver.entities.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.revolver.repositories.TicketRepository;

@Component
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository tr;

	@Override
	public Ticket createTicket(Ticket ticket) {
		System.out.println("entered: createTicket");
		return tr.save(ticket);
		
	}
}
