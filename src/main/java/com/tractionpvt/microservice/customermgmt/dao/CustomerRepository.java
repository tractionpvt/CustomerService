package com.tractionpvt.microservice.customermgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tractionpvt.microservice.customermgmt.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	public Customer findCustomerByInternalCustomerId(String internalCustId);
	
}
