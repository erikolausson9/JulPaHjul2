package com.example.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BookingRepository bookingRepository;

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


	@Test
	void testGetRestaurants()throws SQLException{

		List<Restaurant> restaurants = repository.getRestaurants();
		Assertions.assertEquals(5, restaurants.size());
		//Assertions.assertEquals("hej", restaurants.get(0).getName());

	}

	@Test
	void testAddRestaurant(){
		List<Restaurant> restaurants = repository.getRestaurants();
		int size = restaurants.size();
		Restaurant restaurant =  new Restaurant("hej", "h", 2.5, true, true, 1,1);
		repository.addRestaurant(restaurant);

		restaurants = repository.getRestaurants();
		Assertions.assertEquals(size+1, restaurants.size());
		Assertions.assertEquals("hej", restaurants.get(size).getName());

	}

	@Test
	void testGetMembers() throws SQLException{

		List<Member> members = memberRepository.getMembers();
		Assertions.assertEquals(6,members.size());
	}

	@Test
	void testAddMember(){
		List<Member> members = memberRepository.getMembers();
		int size = members.size();
		Member member = new Member("peter.haggkvist","Peter24","peter.haggkvist@hotmail.com");
		memberRepository.addMember(member);

		members = memberRepository.getMembers();
		Assertions.assertEquals(size+1,members.size());
		Assertions.assertEquals("peter.haggkvist",members.get(size).getAnvandarNamn());
	}

	@Test
	void testGetBooking(){
		Booking booking = new Booking();
		String username = "Aga";
//		booking = bookingRepository.getMyBooking(username);

		Assertions.assertEquals("agalel@gmail.com", booking.getEmail());
	}

}
