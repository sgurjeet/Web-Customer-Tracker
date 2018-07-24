package com.gurjeet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gurjeet.entity.Customer;
import com.gurjeet.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject customerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from dao
		List<Customer> cust=customerService.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers",cust);
		
		return "list-customers";
	}
	
	@GetMapping("/addCustomerForm")
	public String addCustForm(Model model) {
		Customer newCust=new Customer();
		model.addAttribute("customer",newCust);
		return "save-cust-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer cust) {
		customerService.saveCustomer(cust);	
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId")int id,Model model) {
		
		//get cust for id passed in url from db
		Customer cust=customerService.getCustomer(id);
		
		//set cust as model attribute to pre-populate the update form
		model.addAttribute("customer",cust);
		
		//open the update form
		return "save-cust-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int id,Model model) {
			
		//delete cust with id passed in url
		customerService.deleteCustomer(id);
		
		//redirect back to list customers
		return "redirect:/customer/list";
	}
}
