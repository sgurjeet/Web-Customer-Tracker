package com.gurjeet.dao;

import java.util.List;

import com.gurjeet.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
	
}
