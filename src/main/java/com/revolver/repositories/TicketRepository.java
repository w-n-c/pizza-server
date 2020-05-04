package com.revolver.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revolver.entities.Ticket;

@Component
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
	Set<Ticket> findByUserId(int id);
	Ticket createTicket(Ticket ticket);
}
