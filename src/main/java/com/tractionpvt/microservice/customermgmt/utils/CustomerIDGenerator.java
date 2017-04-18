package com.tractionpvt.microservice.customermgmt.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CustomerIDGenerator {

	public String generateUniqueCustID() {
		UUID randomUUID = UUID.randomUUID();
		return "CUST_" + randomUUID.toString().substring(randomUUID.toString().lastIndexOf("-") + 1,
				randomUUID.toString().length());
	}
	
}
