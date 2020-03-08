package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.example.demo.service.NameByCountryService;
import com.example.demo.model.Constants;

@RunWith(MockitoJUnitRunner.class)
public class HolidayControllerTest {

	@Mock
	private NameByCountryService service;
	@InjectMocks
	private HolidayController controller = new HolidayController();
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(service.getByCoun(Constants.COUNTRY1)).thenReturn(Constants.h1);
		when(service.getByCoun(Constants.COUNTRY3)).thenThrow(new NullPointerException(Constants.COUNTRY3 + " no such country"));
		when(service.getByCounAndNum(Constants.COUNTRY2, 1)).thenReturn(Constants.LIST2.get(1));
		when(service.getByCounAndNum(Constants.COUNTRY2, 4)).thenThrow(new NullPointerException("Only "+ Constants.LIST2.size() + " people visited " + Constants.COUNTRY2));
		when(service.getByCounAndNum(Constants.COUNTRY3, 4)).thenThrow(new NullPointerException("No one has visited "+ Constants.COUNTRY3));
	}
	
	@Test
	public void testNotNull() {
		assertThat(this.controller).isNotNull();
	}
	
	@Test
	public void testGetCountry() {
		assertThat(this.controller.getByCountry(Constants.COUNTRY1, null).getBody()).isNotNull().isEqualTo(Constants.h1);
		assertThat(this.controller.getByCountry(Constants.COUNTRY3, null).getBody()).isNotNull().isEqualTo(Constants.COUNTRY3 + " no such country");
		assertThat(this.controller.getByCountry(Constants.COUNTRY3, null).getStatusCode()).isNotNull().isEqualTo(HttpStatus.BAD_REQUEST);
		
		assertThat(this.controller.getByCountry(Constants.COUNTRY2, 1).getBody()).isNotNull().isEqualTo(Constants.LIST2.get(1));
		assertThat(this.controller.getByCountry(Constants.COUNTRY2, 4).getBody()).isNotNull().isEqualTo("Only "+ Constants.LIST2.size() + " people visited " + Constants.COUNTRY2);
		assertThat(this.controller.getByCountry(Constants.COUNTRY3, 4).getStatusCode()).isNotNull().isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(this.controller.getByCountry(Constants.COUNTRY3, 4).getBody()).isNotNull().isEqualTo("No one has visited "+ Constants.COUNTRY3);
		assertThat(this.controller.getByCountry(Constants.COUNTRY3, 4).getStatusCode()).isNotNull().isEqualTo(HttpStatus.BAD_REQUEST);
	}

}
