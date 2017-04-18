package com.tractionpvt.microservice.customermgmt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tractionpvt.microservice.customermgmt.entity.Customer;
import com.tractionpvt.microservice.customermgmt.service.CustomerService;

@Controller
@RequestMapping(path = "/controller/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.findAllCustomers();
		model.addAttribute("customers", customers);
		return "customers";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String setUpForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add_customer";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, 
			RedirectAttributes redirectAttr) {
		
		if(result.hasErrors())
			return "add_customer";
		
		customerService.addCustomer(customer);
		
		return "redirect:/controller/customer/list";
	}

}
