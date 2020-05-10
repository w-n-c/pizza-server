package com.revolver.services;

import java.util.List;

import com.revolver.entities.Topping;
import com.revolver.entities.ToppingCount;

public interface ToppingService {

	List<Topping> getAllToppings();
	
	List<ToppingCount> getCount();
}
