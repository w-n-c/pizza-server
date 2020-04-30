package com.revolver.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int id;
	
	@OneToMany(mappedBy = "ticket")
	private Set<Pizza> pizzas = new HashSet<Pizza>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "placement_time")
	private String placementTime;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "note")
	private String note;

	public Ticket() {
		super();
	}

	public Ticket(Set<Pizza> pizzas, User user, String placementTime, String status, String note) {
		super();
		this.pizzas = pizzas;
		this.user = user;
		this.placementTime = placementTime;
		this.status = status;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPlacementTime() {
		return placementTime;
	}

	public void setPlacementTime(String placementTime) {
		this.placementTime = placementTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", pizzas=" + pizzas.toString() + ", user=" + user.toString() + ", placementTime=" + placementTime
				+ ", status=" + status + ", note=" + note + "]";
	}

}
