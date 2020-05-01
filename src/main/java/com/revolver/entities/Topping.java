package com.revolver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topping")
public class Topping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topping_id")
	private int id;

	@Column(name = "topping_name")
	private String name;

	@Column(name = "topping_cost")
	private double cost;

	public Topping(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public Topping() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Toppings [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}

}
