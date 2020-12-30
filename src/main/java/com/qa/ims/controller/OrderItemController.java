package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderItemDAO;
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderItemController(OrderDAO orderDAO, OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for(OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem.toString());
		}
		return orderItems;
	}

	@Override
	public OrderItem create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
