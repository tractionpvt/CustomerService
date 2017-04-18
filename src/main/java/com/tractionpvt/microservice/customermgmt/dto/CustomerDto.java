package com.tractionpvt.microservice.customermgmt.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto {

	@XmlElement(name = "CustomerId")
	private String customerId;
	
	@XmlElement(name = "CustomerName")
	private String customerName;
	
	@XmlElement(name = "Address")
	private String address;
	
	public CustomerDto() {}

	public CustomerDto(String customerId, String customerName, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", customerName="
				+ customerName + ", address=" + address + "]";
	}
}
