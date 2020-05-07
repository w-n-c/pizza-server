package com.revolver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revolver.entities.Topping;

@Component
@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer> {
	Topping findByName(String name);
}
