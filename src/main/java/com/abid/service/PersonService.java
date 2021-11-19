package com.abid.service;

import java.util.List;

import com.abid.model.Person;



public interface PersonService {
	
	
	public List<Person> getAllPersonDetails();
	public Person getPersonDetails(Integer orderId);
	public Person savePerson(Person order);
	public Person updatePerson(Person order);
	public void deletePerson(Integer orderId);
	
	

}
