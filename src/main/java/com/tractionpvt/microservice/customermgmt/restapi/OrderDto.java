package com.tractionpvt.microservice.customermgmt.restapi;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto {

	@XmlElement(name = "OrderId")
	public String orderId;
	
	@XmlElement(name = "OrderDate")
	public Date orderDate;
	
	@XmlElement(name = "ItemName")
	public String item;
	
	@XmlElement(name = "Quantity")
	public Integer quantity;
	
	@XmlElement(name = "Comments")
	public String comments;	
	
	@XmlElement(name = "OrderStatus")
	public String orderStatus;
	
	public OrderDto() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
