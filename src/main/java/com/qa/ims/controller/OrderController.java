package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private CustomerDAO custDAO;
	private ItemDAO itemDAO;
	private Utils utils;
	private ItemController itemController;
	boolean newOrder = false;
	
	public OrderController(OrderDAO orderDAO, ItemDAO itemDAO, CustomerDAO custDAO, ItemController itemController, Utils utils) {
		super();
		this.itemController = itemController;
		this.itemDAO = itemDAO;
		this.custDAO = custDAO;
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	public List<Customer> readCustomers() {
		LOGGER.info("");
		List<Customer> customers = custDAO.readAll();
		for(Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
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
		newOrder = true;
		update();
		return order;
	}
	
	@Override
	public Order update() {
		Long order_id = 0L;
		if(newOrder) {
			Order order = orderDAO.readLatest();
			order_id = order.getOrder_id();
			newOrder = false;
		}else {
			readAll();
			LOGGER.info("\nPlease enter ID of order to update:");
			order_id = utils.getLong();
		}
		
		String response = "";
		do {
			itemController.readAll();
			LOGGER.info("\nPlease enter ID of item to add:");
			Long item_id = utils.getLong();
			LOGGER.info("\nPlease enter the quantity of the item:");
			Long quantity = utils.getLong();
			Item item = itemDAO.readItem(item_id);
			Long stock = item.getQuantity();
			if(stock < quantity) {
				LOGGER.info("\nERROR: insufficient stock!");
			}
			else {
				for(int i=0; i<quantity; i++) {
					orderDAO.createOrderline(order_id, item_id);
				}
				stock -= quantity;
				item.setQuantity(stock);
				itemDAO.update(item);
			}
			LOGGER.info("\nAdd a different item? [y/n]:");
			response = utils.getString();
		}while(response.equals("y"));
		LOGGER.info("\nOrder Updated!");
		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("\nDelete order (1)\nDelete item (2)");
		Long response = utils.getLong();
		if(response==1L) {
			LOGGER.info("\nPlease enter the id of the order you would like to delete:");
			Long order_id = utils.getLong();
			return orderDAO.delete(order_id);
		}else if(response==2L) {
			deleteItem();
		}else {
			LOGGER.info("\nInvalid selection");
		}
		return 0;
	}
	
	public int deleteItem() {
		readAll();
		LOGGER.info("\nPlease enter the order ID:");
		Long order_id = utils.getLong();
		itemController.readAll();
		LOGGER.info("\nPlease enter the item ID:");
		Long item_id = utils.getLong();
		orderDAO.deleteItem(order_id, item_id);
		return 0;
	}
}
