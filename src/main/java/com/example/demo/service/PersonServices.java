package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		logger.info("Finding all peoples!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person created(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Finding one person!");
		return person;
	}
	
	public void deleted(String id) {
		logger.info("Deleting one person!");
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Matheus");
		person.setLastName("Mendes");
		person.setAddress("Osasco - São Paulo - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil" + i);
		person.setGender("Male");
		return person;
	}
}
