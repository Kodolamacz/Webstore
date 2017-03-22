package com.packt.webstore.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepostiory;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepostiory customerRepostiory;
	
	public ArrayList<Customer> getAllCustomers(){
		return customerRepostiory.getAllCustomers();
	}
}
