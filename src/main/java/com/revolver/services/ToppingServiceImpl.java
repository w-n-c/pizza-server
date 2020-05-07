package com.revolver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revolver.entities.Topping;
import com.revolver.repositories.ToppingRepository;

@Component
@Service
public class ToppingServiceImpl implements ToppingService{
	
	@Autowired
	private ToppingRepository toppingRepository;

	@Override
	public List<Topping> getAllToppings() {
		List<Topping> toppinglist = new ArrayList<>();
		toppingRepository.findAll().forEach(toppinglist::add);
		return toppinglist;
	}

}
