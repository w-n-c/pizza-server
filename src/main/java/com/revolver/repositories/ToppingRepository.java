package com.revolver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revolver.entities.Topping;

@Component
@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer> {
	
	@Query(value = "SELECT TOPPING_ID, " + 
			"             COUNT(TOPPING_ID) AS value_occurrence " + 
			"    FROM     pizza_topping" + 
			"    GROUP BY TOPPING_ID " + 
			"    ORDER BY value_occurrence DESC", nativeQuery = true)
	List<List<Integer>> getCount();
	
	Topping findByName(String name);
}
