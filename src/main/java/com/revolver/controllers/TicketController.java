package com.revolver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revolver.entities.Ticket;
import com.revolver.services.TicketService;

@Component
@Controller
@CrossOrigin("*")
public class TicketController {
	
	@Autowired 
	TicketService ts;
	
	@ResponseBody
	@PostMapping("/users")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		System.out.println("entered");
		return ts.createTicket(ticket);
	}

}
