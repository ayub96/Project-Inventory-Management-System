package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long order_id;
	private Long customer_id;
	String date;
	private List<Item> items = new ArrayList<>();
	
	public Order() {

	}
	
	public Order(Long customer_id) {
		this.customer_id = customer_id;
	}
	
	public Order(Long order_id, Long customer_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
	}
	
	public Order(Long order_id, Long customer_id, String date, List<Item> items) {
		super();
		this.date = date;
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
	}
	
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	
	@Override
	public String toString() {
		double total = 0.0;
		String myItems = "";
		for(Item item : items) {
			total = total + item.getPrice();
			myItems = myItems + item.toOrderString() + "\n";
		}
		return "[order ID]: " + order_id 
				+ "\n [customer ID]: " + customer_id
				+ "\n [last updated]: " + date
				+ "\n [items]:\n" + myItems 
				+ " [Total]: " + total;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} 
//		else if (!items.equals(other.items))
//			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		return true;
	}

}
