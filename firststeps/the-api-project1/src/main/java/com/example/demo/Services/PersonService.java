package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;


@Service
public class PersonService {
	
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll() {
		logger.info("finding all people");
		
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPeople(i);
			people.add(person);
		}
		
		
		return people;
	}
	

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
	
	
	private Person mockPeople(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Person Last Name" + i);
		person.setAddress("Person address");
		person.setGender("Person Gender");
		return person;
	}

	
}
