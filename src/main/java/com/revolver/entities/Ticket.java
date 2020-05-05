package com.revolver.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int id;

	@JsonManagedReference
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	private Set<Pizza> pizzas = new HashSet<Pizza>();

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "user_id")
	private User user;

	@CreationTimestamp
	@Column(name = "placement_time")
	private LocalDateTime placementTime;

	@Column(name = "status")
	private String status;

	@Column(name = "note")
	private String note;

	public Ticket() {
		super();
	}

	public Ticket(Set<Pizza> pizzas, User user, LocalDateTime placementTime, String status, String note) {
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

	public LocalDateTime getPlacementTime() {
		return placementTime;
	}

	public void setPlacementTime(LocalDateTime placementTime) {
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
		return "Ticket [id=" + id + ", pizzas=" + pizzas + ", user=" + user.getUsername() + ", placementTime="
				+ placementTime + ", status=" + status + ", note=" + note + "]";
	}

}
