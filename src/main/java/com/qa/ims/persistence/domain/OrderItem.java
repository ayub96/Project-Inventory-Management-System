package com.qa.ims.persistence.domain;

public class OrderItem {

	private Long orderItemId;
	private Long orderId;
	private Long itemId;
	
	public OrderItem(Long orderItemId, Long orderId, Long itemId) {
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	public OrderItem(Long orderId, Long itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String toString() {
		return "order id:" + orderId +  " item id:" + itemId;
	}
	
}
