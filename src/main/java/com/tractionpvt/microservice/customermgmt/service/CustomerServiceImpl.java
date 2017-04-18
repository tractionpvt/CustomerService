package com.tractionpvt.microservice.customermgmt.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.UncategorizedJmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tractionpvt.microservice.customermgmt.dao.CustomerRepository;
import com.tractionpvt.microservice.customermgmt.dto.OrderDto;
import com.tractionpvt.microservice.customermgmt.entity.Customer;
import com.tractionpvt.microservice.customermgmt.utils.CustomerIDGenerator;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerIDGenerator custIDGenerator;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addCustomer(Customer customer) {
		customer.setInternalCustomerId(custIDGenerator.generateUniqueCustID());
		customerRepository.save(customer);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void placeOrder(Long customerId, OrderDto orderDto) {
		Customer customer = customerRepository.findOne(customerId);
		Calendar calendar = Calendar.getInstance();
		orderDto.setOrderDate(calendar.getTime());
		orderDto.setCustomerInternalId(customer.getInternalCustomerId());
		
		// Constructing JMS Map Message
		Map<String,String> mapMessage = new HashMap<>();
		mapMessage.put("customerInternalId", orderDto.getCustomerInternalId());
		mapMessage.put("orderDate", String.valueOf(calendar.getTimeInMillis()));
		mapMessage.put("quantity", String.valueOf(orderDto.getQuantity()));
		mapMessage.put("item", orderDto.getItemName());
		mapMessage.put("description", orderDto.getDescription());
		
		try {
			jmsTemplate.convertAndSend("OrderQueue", mapMessage);
		} catch (UncategorizedJmsException jmsException) {
			System.out.println("Seems like Queue is not up and running");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findCustomerByInternalCustomerId(String internalCustomerId) {
		Customer customer = customerRepository.findCustomerByInternalCustomerId(internalCustomerId);
		return customer;
	}
}
