package com.qa.ims.controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private Utils utils;
	private ItemController itemController;
	
	public OrderController(OrderDAO orderDAO, ItemDAO itemDAO, ItemController itemController, Utils utils) {
		super();
		this.itemController = itemController;
		this.itemDAO = itemDAO;
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		LOGGER.info("");
		List<Order> orders = orderDAO.readAll();
		for(Order order : orders) {
			LOGGER.info(order.toString() + "\n");
		}
		return orders;
	}
	
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer ID");
		Long customer_id = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id));
		LOGGER.info("Order created! (ID:" + order.getOrder_id() + ")\n");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter ID of order to update");
		readAll();
		Long order_id = utils.getLong();
		Long response = 0L;
		do {
			LOGGER.info("Please enter ID of item to add");
			itemController.readAll();
			Long item_id = utils.getLong();
			LOGGER.info("Please enter the quantity of the item");
			Long quantity = utils.getLong();
			Item item = itemDAO.readItem(item_id);
			if(item.getQuantity() < quantity) {
				LOGGER.info("ERROR: desired quantity exceeds stock!");
			}
			else {
				for(int i=0; i<quantity; i++) {
					orderDAO.createOrderline(order_id, item_id);
				}
				LOGGER.info("Order updated!");
			}
			LOGGER.info("Add another item? (1:yes/2:no)");
			response = utils.getLong();
		}while(response == 1);
		LOGGER.info("Order Updated!");
		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}
}
