package com.tractionpvt.microservice.customermgmt.service;

import java.util.List;

import com.tractionpvt.microservice.customermgmt.dto.OrderDto;
import com.tractionpvt.microservice.customermgmt.entity.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();
	public void addCustomer(Customer customer);
	public Customer findCustomerByInternalCustomerId(String internalCustomerId);
	
	public void placeOrder(Long customerId,OrderDto orderDto);
	
}
