package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String itemName;
	private Long quantity;
	private double price;
	
	public Item(Long id, String itemName, Long quantity, double price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item(String itemName, Long quantity, double price) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public Item(Long id) {
		this.id = id;
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "{id: " + id + "\tname: " + itemName + "\tprice: " + price + "\tstock: " + quantity + "}";
	}
	
	public String toOrderString() {
		return "  {id: " + id + "\tname: " + itemName + "\tprice: " + price + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
