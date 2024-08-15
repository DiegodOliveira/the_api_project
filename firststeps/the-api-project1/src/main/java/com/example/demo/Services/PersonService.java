package com.example.demo.Services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;


@Service
public class PersonService {
	
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		
		logger.info("finding one person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Diego");
		person.setLastName("Cipriano");
		person.setAddress("João Pessoa");
		person.setGender("Male");
		return person;
	}
	
}
