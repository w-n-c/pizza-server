package com.revolver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revolver.entities.Topping;
import com.revolver.entities.ToppingCount;
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

	@Override
	public List<ToppingCount> getCount() {
		// we receive an array of integer pairs, [toppingId, count]
		List<List<Integer>> rawValues = toppingRepository.getCount();
		
		List<ToppingCount> toppingOrder = new ArrayList<ToppingCount>();
		for (List<Integer> data : rawValues) {
			// find a topping from toppingId (the first value in the pair)
			Topping topping = toppingRepository.findById(data.get(0)).get();
			ToppingCount tc = new ToppingCount();
			tc.setTopping(topping);
			tc.setCount(data.get(1));
			toppingOrder.add(tc);
		}
		return toppingOrder;
	}
	
	

}
