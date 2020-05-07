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
import com.revolver.services.TicketService;

@SpringBootTest
@Transactional
class PizzaServerApplicationTests {

	@Autowired
	UserRepository ur;

	@Autowired
	TicketRepository tr;

	@Autowired
	TicketService ts;

	@Autowired
	PizzaRepository pr;

	@Autowired
	ToppingRepository topr;

	@Test
	void createTicket() {
		User user = ur.findById(1).get();
		Ticket order = new Ticket();
		order.setUser(user);
		tr.save(order);
		Assertions.assertTrue(order.getPlacementTime() != null);
		Assertions.assertTrue(user.getTickets().contains(order));
	}

	@Test
	void createTicketService() {
		User user = ur.findById(1).get();
		Ticket order = new Ticket();
		order.setUser(user);
		ts.createTicket(order);
		Assertions.assertEquals(order.getStatus(), "pending");
		Assertions.assertTrue(user.getTickets().contains(order));
	}

	@Test
	void findTicketsByUsername() {
		Set<Ticket> expected = ur.findByUsername("newellwm").getTickets();
		Set<Ticket> result = ts.findTicketByUsername("newellwm");
		Assertions.assertEquals(expected, result);
	}

	@Test
	void getUser() {
		User user = ur.findById(1).get();
		Assertions.assertTrue(user.getUsername().equals("newellwm"));
		Assertions.assertTrue(user.getRole().getTitle().equals("employee"));
	}

	@Test
	void findByUsernameAndPassword() {
		User test = new User();
		test.setUsername("newellwm");
		test.setPassword("password");
		User actual = ur.findByUsernameAndPassword("newellwm", "password");
		User expected = ur.findById(1).get();
		Assertions.assertEquals(actual, expected);
	}

	@Test
	void getTicketByUserId() {
		Set<Ticket> actual = tr.findByUserId(1);
		Set<Ticket> expected = ur.findById(1).get().getTickets();
		Assertions.assertEquals(actual, expected);
	}
	
	@Test
	void updateTicket() {
		Ticket ticket = tr.findById(1).get();
		ticket.setStatus("a test status");
		Ticket actual = ts.updateTicket(ticket);
		Assertions.assertEquals(actual.getStatus(), "a test status");
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

	@Test
	void createPizza() {
		Pizza pizza = new Pizza();
		Topping cheese = topr.findByName("cheese");
		Topping pepperoni = topr.findByName("pepperoni");
		pizza.addTopping(cheese);
		pizza.addTopping(pepperoni);
		pr.save(pizza);
		Assertions.assertTrue(pizza.getId() > 0);
		Assertions.assertEquals(pizza.getToppings().size(), 2);
	}
}
