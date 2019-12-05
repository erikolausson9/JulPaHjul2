package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	RestaurantRepository repository;

	@Test
	void contextLoads() {
	}


	@Test
	void testAddRestaurantAndSort(){
		Restaurant testRestaurant = new Restaurant("TestRestaurang", "Denna restaurant serverar ett julbord med alla delikatesser.", 5.5,true, true, 55.604640, 12.996836);
		RestaurantRepository restaurantRepository = new RestaurantRepository();
		//restaurantRepository.create20FakeRestaurants();
		restaurantRepository.addRestaurant(testRestaurant);
		List<Restaurant> sortedRestaurants = restaurantRepository.getSortedRestaurantList(0, 20, false, false);
		Assertions.assertEquals("TestRestaurang", sortedRestaurants.get(0).getName());

		restaurantRepository.addRestaurant(new Restaurant("TestRestaurang2", "Även denna restaurant serverar ett julbord med alla delikatesser.", 5.5,true, true, 55.604640, 12.996836));
		sortedRestaurants = restaurantRepository.getSortedRestaurantList(0, 20, false, false);
		Assertions.assertEquals("TestRestaurang2", sortedRestaurants.get(1).getName());

	}

	@Test
	void testSQLServler() throws SQLException {
		Assertions.assertTrue(repository.testDB());
	}


}
