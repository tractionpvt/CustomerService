package com.tractionpvt.microservice.customermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tractionpvt.microservice.customermgmt.restapi.OrderDtoList;

@Service
public class RemoteOrderService {

	@Autowired
	private RemoteOrderServiceCall remoteOrderService;
	
	@HystrixCommand(fallbackMethod = "handleCustomerOrdersFromRemoteOrderServiceFallback")
	public OrderDtoList getAllCustomerOrdersFromRemoteOrderService(String customerId) {
		return remoteOrderService.findAllCustomerOrdersForCustomerId(customerId);		
	}
	
	public OrderDtoList handleCustomerOrdersFromRemoteOrderServiceFallback(String customerId) {
		return new OrderDtoList();
	}
	
}
