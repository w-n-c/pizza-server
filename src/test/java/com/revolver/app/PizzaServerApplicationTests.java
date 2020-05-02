package com.revolver.app;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revolver.entities.Pizza;
import com.revolver.entities.Ticket;
import com.revolver.entities.Topping;
import com.revolver.entities.User;
import com.revolver.repositories.PizzaRepository;
import com.revolver.repositories.TicketRepository;
import com.revolver.repositories.ToppingRepository;
import com.revolver.repositories.UserRepository;

@SpringBootTest
@Transactional
class PizzaServerApplicationTests {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	TicketRepository tr;
	
	@Autowired
	PizzaRepository pr;
	
	@Autowired
	ToppingRepository topr;

	@Test
	void getUser() {
		User user = ur.findById(1).get();
		Assertions.assertTrue(user.getUsername().equals("newellwm"));
		Assertions.assertTrue(user.getRole().getTitle().equals("employee"));
	}
	
	@Test
	void getTicketByUserId() {
		Set<Ticket> actual = tr.findByUserId(1);
		Set<Ticket> expected = ur.findById(1).get().getTickets();
		Assertions.assertEquals(actual, expected);
	}
	
	@Test
	void getPizzaByTicketId() {
		Set<Pizza> actual = pr.findByTicketId(1);
		Set<Pizza> expected = tr.findById(1).get().getPizzas();
		Assertions.assertEquals(actual, expected);
	}
	
	@Test
	void getToppingsByName() {
		Topping cheese = topr.findByName("cheese");
		Topping pepperoni = topr.findByName("pepperoni");
		Assertions.assertEquals(cheese.getId(), 1);
		Assertions.assertEquals(pepperoni.getId(), 2);
	}

}
