package com.revolver.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revolver.entities.Ticket;
import com.revolver.entities.User;
import com.revolver.services.TicketService;

@Component
@Controller
@CrossOrigin
public class TicketController {

	@Autowired
	TicketService ts;

	@ResponseBody
	@GetMapping("/tickets")
	public Set<Ticket> getAllTickets() {
		return ts.findAllTickets();
	}

	@ResponseBody
	@PostMapping("/tickets")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ts.createTicket(ticket);
	}

	@ResponseBody
	@PostMapping("/tickets/")
	public Set<Ticket> getByUsername(@RequestBody User user) {
		return ts.findTicketByUsername(user.getUsername());
	}
	
	@ResponseBody
	@PostMapping("/tickets/{id}")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return ts.updateTicket(ticket);
	}

}
