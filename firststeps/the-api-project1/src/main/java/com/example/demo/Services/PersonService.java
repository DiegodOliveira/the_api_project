package com.example.demo.Services;

//import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;


@Service
public class PersonService {
	
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all people");
		
		
		return repository.findAll();
	}
	

	public Person findById(Long id) {
		
		logger.info("finding one person");
		
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
	}
	
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getAddress());
		
		return repository.save(person);
		
	}

	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

		repository.delete(entity);
		
	}
	


	
}
