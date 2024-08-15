package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.PersonService;
//import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;
//import com.example.demo.math.SimpleMath;
import com.example.demo.model.Person;



@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private PersonService service;
	
	@RequestMapping(value = "/{id}",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception{
				{
		return service.findById(id);	
		}
}
	
	
}	