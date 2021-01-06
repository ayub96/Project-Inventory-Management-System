package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	public List<Customer> readCustomers() {
		LOGGER.info("");
		List<Customer> customers = orderDAO.readAllCustomers();
		for(Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}
	
	public List<Item> readItems() {
		LOGGER.info("");
		List<Item> items = orderDAO.readAllItems();
		for(Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for(Order order : orders) {
			LOGGER.info("\n" + order.toString());
		}
		return orders;
	}
	
	@Override
	public Order create() {
		readCustomers();
		LOGGER.info("\nPlease enter the customer ID:");
		Long customer_id = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id));
		addItems(order.getOrder_id(), true);
		return order;
	}
	
	@Override
	public Order update() {
		
		readAll();
		LOGGER.info("\nPlease enter ID of order to update:");
		Long order_id = utils.getLong(); 
		
		LOGGER.info("\nADD:\tAdd items to an order\nDELETE:\tDelete items from an order");
		String selection = utils.getString().toLowerCase();
		
		Order response = new Order();
		
		switch(selection) {
			case "add":
				response = addItems(order_id, false);
				break;
			case "delete":
				deleteItem(order_id);
				response = null;
				break;
			default:
				LOGGER.info("\nInvalid selection");
				break;
			}
		return response;
	}

	public Order addItems(Long order_id, boolean newItem) {
		String response = "";
		Order updated_order = null;
		do {
			readItems();
			LOGGER.info("\nPlease enter ID of item to add:");
			Long item_id = utils.getLong();
			LOGGER.info("\nPlease enter the quantity of the item:");
			Long quantity = utils.getLong();
			Item item = orderDAO.readItem(item_id);
			Long stock = item.getQuantity();
			if(stock < quantity) {
				LOGGER.info("\nERROR: insufficient stock!");
			}
			else {
				for(int i=0; i<quantity; i++) {
					updated_order = orderDAO.createOrderline(order_id, item_id);
				}
				stock -= quantity;
				item.setQuantity(stock);
				orderDAO.updateItem(item);
			}
			LOGGER.info("\nAdd another item? [y/?]:");
			response = utils.getString();
		}while(response.equals("y"));
		if(newItem) {
			LOGGER.info("\nOrder created!");
		}else {
			LOGGER.info("\nOrder Updated!");
		}
		return updated_order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("\nPlease enter the id of the order you would like to delete:");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}
	
	public int deleteItem(Long order_id) {	// Should return int?
		LOGGER.info("\nPlease enter the ID of the item to delete:");
		Long item_id = utils.getLong();
		return orderDAO.deleteItem(order_id, item_id);
	}
}
