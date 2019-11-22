package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testAddRestaurantAndSort(){
		Restaurant restaurant = new Restaurant("TestRestaurang", "Denna restaurant serverar ett julbord med alla delikatesser.", 5.5,true, true, 55.604640, 12.996836);

	}


}
