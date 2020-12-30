package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long item_id;
	private List<Item> items = new ArrayList<>();
	
	public Order() {

	}
	
	public Order(Long customer_id) {
		this.customer_id = customer_id;
	}
	
	public Order(Long order_id, Long customer_id) {	//super here?
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		
	}
	
	public Order(Long order_id, Long customer_id, List<Item> items) {	//super here?
		super();
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
			myItems = myItems + item.toString() + "\n";
		}
		return "[order ID: " + order_id +  "]\n[customer ID: " + customer_id + "]\n[items]:\n" + myItems + "[Total cost: £" + total + "]\t";
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	
}
