package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long date_placed;
	private double total;
	
	public Order(Long order_id, Long customer_id, Long date_placed, double total) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.total = total;
	}
	
	public Order(Long customer_id, Long date_placed, double total) {
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.total = total;
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

	public Long getDate_placed() {
		return date_placed;
	}

	public void setDate_placed(Long date_placed) {
		this.date_placed = date_placed;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
