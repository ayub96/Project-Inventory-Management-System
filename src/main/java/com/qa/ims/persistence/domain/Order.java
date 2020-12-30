package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long item_id;
	private String date;
	private List<Item> items = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	
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
	
	public Order(Long order_id, Long customer_id, List<Item> items, String date, List<Customer> customers) {	//super here?
		super();
		this.date = date;
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
		this.customers = customers;
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
		String myCustomers = "";
		for(Item item : items) {
			total = total + item.getPrice();
			myItems = myItems + item.toOrderString() + "\n";
		}
		for(Customer customer : customers) {
			myCustomers = myCustomers + customer.toOrderString();
		}
		return "[order ID]: " + order_id 
				+ "\n [customer ID]: " + customer_id
				+ "\n [customer name]: " + myCustomers
				+ "\n [Last updated]: " + date 
				+ "\n [items]:\n" + myItems 
				+ " [Total]: £" + total;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
