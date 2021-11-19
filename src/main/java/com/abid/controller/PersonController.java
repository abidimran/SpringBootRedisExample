package com.abid.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abid.model.Person;
import com.abid.service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {


	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/ping")
	public ResponseEntity<String> Ping() {

		System.out.println("Coming for Person Ping");
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@GetMapping("/all-persons")
	public ResponseEntity<?> getAllPersonDetails(){

		List<Person> persons = personService.getAllPersonDetails();
		if(persons.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("No Person Details Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(persons);
	}

	@GetMapping("/person/{personId}")
	public ResponseEntity<?> getPerson(@PathVariable("personId") Integer personId){
		try {
			Person person =personService.getPersonDetails(personId);
			return ResponseEntity.status(HttpStatus.OK).body(person);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Person Detail Found");
		}
	}

	@PostMapping("/person")
	public ResponseEntity<Person> creatingPerson(@RequestBody Person person){
		System.out.println("PersonName: "+person.getName()+ 
				" PersonCity: "+person.getCity());
		Person food = personService.savePerson(person);
		return ResponseEntity.status(HttpStatus.OK).body(food);
	}

	@DeleteMapping("/person/{personId}")
	public ResponseEntity<String> deletePerson(@PathVariable("personId") Integer personId){
		try {
			personService.deletePerson(personId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Person Detail Found");
		}
	}

	@PutMapping("/person")
	public ResponseEntity<?> updatePerson(@RequestBody Person person){
		try {
			personService.updatePerson(person);
			person =personService.getPersonDetails(person.getId());
			return ResponseEntity.status(HttpStatus.OK).body(person);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Person Detail Found");
		}

	}


}
