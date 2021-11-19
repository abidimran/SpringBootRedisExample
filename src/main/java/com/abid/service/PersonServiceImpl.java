package com.abid.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.abid.model.Person;
import com.abid.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService{

	private PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getAllPersonDetails() {
		return (List<Person>) personRepository.findAll();
	}

	public Person getPersonDetails(Integer personId) {
		
		Optional<Person> response = personRepository.findById(personId);
		return response.get();
	}

	public Person savePerson(Person person) {
		Person responsePerson = personRepository.save(person);
		
		return responsePerson;
	}

	public Person updatePerson(Person person) {
		
		Person responsePerson = Person.builder().Id(person.getId())
				.name(person.getName())
				.city(person.getCity()).build();
				
		
		return personRepository.save(responsePerson);
	}

	public void deletePerson(Integer personId) {
		personRepository.deleteById(personId);
	}

}
