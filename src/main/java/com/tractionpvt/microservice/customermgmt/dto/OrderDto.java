package com.tractionpvt.microservice.customermgmt.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class OrderDto {

	@NotNull
	private Integer quantity;

	@NotBlank
	private String itemName;
	private String description;
	private Date orderDate;

	private String customerInternalId;

	public OrderDto() {
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerInternalId() {
		return customerInternalId;
	}

	public void setCustomerInternalId(String customerInternalId) {
		this.customerInternalId = customerInternalId;
	}

}
