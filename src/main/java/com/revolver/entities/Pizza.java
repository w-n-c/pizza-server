package com.revolver.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	@ManyToMany
	@JoinTable(
		name = "pizza_topping",
		joinColumns = { @JoinColumn(name = "pizza_id") },
		inverseJoinColumns = {@JoinColumn(name = "topping_id") }
	)
	private Set<Topping> toppings = new HashSet<Topping>();

	public Pizza() {
		super();
	}

	public Pizza(Ticket ticket, Set<Topping> toppings) {
		super();
		this.ticket = ticket;
		this.toppings = toppings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Set<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(Set<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", ticket=" + ticket.getId() + ", toppings=" + toppings + "]";
	}

}
