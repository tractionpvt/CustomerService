package com.tractionpvt.microservice.customermgmt.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tractionpvt.microservice.customermgmt.dto.CustomerDto;
import com.tractionpvt.microservice.customermgmt.entity.Customer;
import com.tractionpvt.microservice.customermgmt.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/restapi/customer/{custId}",method = RequestMethod.GET)
	public ResponseEntity<CustomerDto> findCustomerDetails(@PathVariable("custId") String internalCustomerId) {
		Customer customer = customerService.findCustomerByInternalCustomerId(internalCustomerId);
		CustomerDto customerDto = new CustomerDto();
		if(customer != null) {
			customerDto.setCustomerId(customer.getInternalCustomerId());
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setAddress(customer.getAddress());
		}
		return new ResponseEntity<>(customerDto,HttpStatus.OK);
	}
	
}
