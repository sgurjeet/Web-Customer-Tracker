package com.gurjeet.service;

import java.util.List;

import com.gurjeet.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
}
