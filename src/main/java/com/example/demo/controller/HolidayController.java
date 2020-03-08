package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Constants;
import com.example.demo.service.NameByCountryService;


@RestController
public class HolidayController {
    
	@Autowired
	private NameByCountryService service;
	
	
	@GetMapping({Constants.WILDCARD_MAPPING, Constants.WILDCARD_MAPPING1})
    public ResponseEntity<Object> getByCountry(@PathVariable String country, @PathVariable(required = false) Integer number)
    {
		if(number!= null)
		{
			try 
			{return new ResponseEntity<>(this.service.getByCounAndNum(country, number), HttpStatus.OK);}
			catch(NullPointerException e)
			{return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
		}
		else
		{
			try 
			{return new ResponseEntity<>(this.service.getByCoun(country), HttpStatus.OK);}
			catch(NullPointerException e)
			{return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
		}
    }
	
	/*	@GetMapping(Constants.WILDCARD_MAPPING)
    public ResponseEntity<HolidayInfo> getByCountry(@PathVariable String country)
    {
		try 
		{return new ResponseEntity<>(this.service.getByCoun(country), HttpStatus.OK);}
		catch(NullPointerException e)
		{return new ResponseEntity<>(Constants.h3, HttpStatus.BAD_REQUEST);}
    }
	
	@GetMapping(Constants.WILDCARD_MAPPING1)
	public ResponseEntity<String> getByCountryAndNumber(@PathVariable String country, @PathVariable int number)
    {
		try 
		{return new ResponseEntity<>(this.service.getByCounAndNum(country, number), HttpStatus.OK);}
		catch(NullPointerException e)
		{return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);}
		
    }*/
}
