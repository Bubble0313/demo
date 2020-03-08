package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Constants;

@RunWith(SpringRunner.class)
class NameByCountryServiceTest {

	@Autowired
	private NameByCountryService service = new NameByCountryService();
	
	@Test
	void testNouNull() {
		assertThat(this.service).isNotNull();
	}
	
	@Test
	void testGetCoun() {
		assertThat(this.service.getByCoun(Constants.COUNTRY1)).isNotNull().isEqualTo(Constants.h1);
		Exception exception = Assertions.assertThrows(NullPointerException.class, () -> this.service.getByCoun(Constants.COUNTRY3));
		Assertions.assertEquals(Constants.COUNTRY3 + " no such country", exception.getMessage());
	}

	@Test
	void testGetCounAndNum() {
		assertThat(this.service.getByCounAndNum(Constants.COUNTRY2,1)).isNotNull().isEqualTo(Constants.LIST2.get(1));
		Exception exception1 = Assertions.assertThrows(NullPointerException.class, () -> this.service.getByCounAndNum(Constants.COUNTRY2,4));
		Assertions.assertEquals("Only "+ Constants.LIST2.size() + " people visited " + Constants.COUNTRY2, exception1.getMessage());
		Exception exception2 = Assertions.assertThrows(NullPointerException.class, () -> this.service.getByCounAndNum(Constants.COUNTRY3,4));
		Assertions.assertEquals("No one has visited "+ Constants.COUNTRY3, exception2.getMessage());
	}

}
