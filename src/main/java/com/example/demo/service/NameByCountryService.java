package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.HolidayInfo;
import com.example.demo.model.Constants;

@Service
public class NameByCountryService {
	private Map<String, HolidayInfo> data = new HashMap<>();
	
	public NameByCountryService() {
		data.put(Constants.COUNTRY1, Constants.h1);
		data.put(Constants.COUNTRY2, Constants.h2);
	}
	
	public Object getByCoun(String country) {
		
		if(this.data.containsKey(country)) {
			return this.data.get(country);
		}
		else throw new NullPointerException(country + " no such country");
	}

	public Object getByCounAndNum(String country, Integer number) {
		if (this.data.containsKey(country)) {
			List<String> list = this.data.get(country).getVisitors().getName();
			if (number >= 0 && number < list.size()) {
				return list.get(number);
			}
			else throw new NullPointerException("Only "+ list.size() + " people visited " + country);
		}
		else throw new NullPointerException("No one has visited "+ country);
	}
}
