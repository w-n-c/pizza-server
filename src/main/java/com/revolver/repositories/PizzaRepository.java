package com.revolver.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revolver.entities.Pizza;

@Component
@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer> {
	Set<Pizza> findByTicketId(int id);
}
