package com.revolver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revolver.entities.Topping;
import com.revolver.entities.ToppingCount;
import com.revolver.services.ToppingService;

@Component
@Controller
@CrossOrigin
public class ToppingController {
	
	@Autowired
	ToppingService toppingService;
	
	@ResponseBody
	@GetMapping("/toppings")
	public List<Topping> getAllToppings() {
		return toppingService.getAllToppings();
	}
	
	@ResponseBody
	@GetMapping("/toppings/count")
	public List<ToppingCount> getToppingCount() {
		return toppingService.getCount();
	}
	
}
