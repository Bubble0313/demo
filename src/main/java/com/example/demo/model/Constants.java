package com.example.demo.model;

import java.util.Arrays;
import java.util.List;
import com.example.demo.model.HolidayInfo;
import com.example.demo.model.VisitorInfo;

public class Constants {
	public static final String WILDCARD_MAPPING = "/{country}";
	public static final String WILDCARD_MAPPING1 = "/{country}/{number}";
	public static final String COUNTRY1 = "Usa";
	public static final String COUNTRY2 = "Canada";
	public static final String COUNTRY3 = "China";	
	public static List<String> LIST1 = Arrays.asList("Amy", "Emma"); 
	public static List<String> LIST2 = Arrays.asList("Guru", "Steve", "Sudheep");
	public static List<String> LIST3 = Arrays.asList("EMPTY");
	public static VisitorInfo v1 = new VisitorInfo(LIST1);
	public static HolidayInfo h1 = new HolidayInfo(COUNTRY1, v1);
	public static VisitorInfo v2 = new VisitorInfo(LIST2);
	public static HolidayInfo h2 = new HolidayInfo(COUNTRY2, v2);
	public static VisitorInfo v3 = new VisitorInfo(LIST3);
	public static HolidayInfo h3 = new HolidayInfo("EMPTY", v3);	
}
