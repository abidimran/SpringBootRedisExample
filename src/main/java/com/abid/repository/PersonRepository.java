package com.abid.repository;

import org.springframework.data.repository.CrudRepository;

import com.abid.model.Person;


public interface PersonRepository extends CrudRepository<Person, Integer>{

}
