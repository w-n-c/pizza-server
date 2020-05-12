package com.revolver.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revolver.entities.Ticket;
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
	@GetMapping(value="user/{username}/tickets")
	public Set<Ticket> getByUsername(@PathVariable("username") String username) {
		return ts.findTicketByUsername(username);
	}

	//only the status is updated by the front-end
	@ResponseBody
	@PatchMapping("/tickets/{id}")
	public Ticket updateTicket(@PathVariable("id") int id, @RequestBody Ticket ticket) {
		ticket.setId(id);
		return ts.updateTicketStatus(ticket);
	}

	@ResponseBody
	@GetMapping(value ="/tickets", params = { "page" })
	public Slice<Ticket> findPaginated(@RequestParam("page") int page) {
		Slice<Ticket> results = ts.findByPage(page);
		return results;
	}
}
