package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepostiory;

@Repository
public class InMemoryCustomerRepository implements CustomerRepostiory{
	
	private ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
	public InMemoryCustomerRepository() {
	
		Customer cust1 = new Customer("C1","Janek");
		Customer cust2 = new Customer("C2","Zygfryd");
		Customer cust3 = new Customer("C3","Wombat");
		
		listOfCustomers.add(cust1);
		listOfCustomers.add(cust2);
		listOfCustomers.add(cust3);
		
	}
	
	public ArrayList<Customer> getAllCustomers(){
		return listOfCustomers;
	}
}
