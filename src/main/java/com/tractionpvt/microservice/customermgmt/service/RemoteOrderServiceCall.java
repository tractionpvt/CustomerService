package com.tractionpvt.microservice.customermgmt.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tractionpvt.microservice.customermgmt.restapi.OrderDtoList;

@FeignClient(name = "OrderService")
public interface RemoteOrderServiceCall {

	@RequestMapping(method = RequestMethod.GET,path = "/restapi/order/{customerId}")
	public OrderDtoList findAllCustomerOrdersForCustomerId(@PathVariable("customerId") String customerId);
	
	
}
