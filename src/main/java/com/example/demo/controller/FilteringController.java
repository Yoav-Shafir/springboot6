package com.example.demo.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/static-filtering")
	public SomeBean someBean() {
		return new SomeBean("value1", "value2", "value3","value4");
	}
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue someBean2() {
		SomeBean2 someBean2 = new SomeBean2("value1", "value2", "value3","value4");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBean2Filter", filter);
	
		MappingJacksonValue mapping = new MappingJacksonValue(someBean2);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
