package com.tractionpvt.microservice.customermgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Table(name = "customers")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", length = 11, nullable = false, unique = true)
	private Long id;
	
	@Column(name = "internal_cust_id",length = 255, nullable = false, unique = true)
	private String internalCustomerId;
	
	@Column(name = "customer_name",length = 255)
	@NotBlank
	private String customerName;
	
	@Column(name = "house_no",length = 10)
	@NotBlank
	private String houseNo;
	
	@Column(name = "street_name",length = 100)
	@NotBlank
	private String streetName;
	
	@Column(name = "city",length = 100)
	@NotBlank
	private String city;
	
	@Column(name = "zipcode",length = 10)
	@NotBlank
	private String zipCode;
	
	@Column(name = "country",length = 100)
	@NotBlank
	private String country;
	
	@Transient
	private String address;
	
	public Customer() {}

	public Customer(String customerName, String houseNo, String streetName,String city, String zipCode, String country) {
		this.customerName = customerName;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getInternalCustomerId() {
		return internalCustomerId;
	}

	public void setInternalCustomerId(String internalCustomerId) {
		this.internalCustomerId = internalCustomerId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return getStreetName() + " " + getHouseNo() + " " 
				+ getZipCode() + " " + getCity() + " "
				+ getCountry();
	}
	
	@Override
	public String toString() {
		return "Customer [internalCustomerId=" + internalCustomerId
				+ ", customerName=" + customerName + "]";
	}
}
