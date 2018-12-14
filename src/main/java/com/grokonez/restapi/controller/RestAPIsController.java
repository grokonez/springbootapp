package com.grokonez.restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.restapi.model.Customer;
import com.grokonez.restapi.repository.CustomerRepository;
 
@RestController
public class RestAPIsController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		// save a list of Customers
		repository.save(Arrays.asList(new Customer("Jack", "Smith"), new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
										new Customer("David", "Williams"), new Customer("Peter", "Davis")));
		
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public List<Customer> findAll(){
		return (List<Customer>) repository.findAll();
	}
	
	@RequestMapping("/findbyid")
	public Customer findById(@RequestParam("id") long id){
		return repository.findOne(id);
	}
	
	@RequestMapping("/findbylastname")
	public List<Customer> fetchDataByLastName(@RequestParam("lastname") String lastName){
		return repository.findByLastName(lastName);
	}
}