package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.PersonService;
//import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;
//import com.example.demo.math.SimpleMath;
import com.example.demo.vo.v1.PersonVO;



@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private PersonService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
			return service.findAll();	
		}

	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception{
				{
		return service.findById(id);	
		}
}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person ){
			return service.create(person);	
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person ){ 
		return service.update(person);	
	}
	
	@DeleteMapping(value = "/{id}")
	public 	ResponseEntity<?> delete(@PathVariable (value = "id")Long id){
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}
	
	
}	