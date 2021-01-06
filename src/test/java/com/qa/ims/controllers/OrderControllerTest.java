package com.qa.ims.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private OrderDAO orderDAO;
	
	@Mock
	private CustomerDAO custDAO;
	
	@Mock
	private ItemDAO itemDAO;
	
	@Mock
	private Utils utils;
	
	@Mock
	private ItemController itemController;
	
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void testCreate() {
		final Long customerId = 1L;
		final Long itemId = 1L;
		
		Order created = new Order(customerId);
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(customerId, "john", "smith"));
		
		List<Item> items = new ArrayList<>();
		Item item = new Item(itemId, "FIFA", 11L, 39.99);
		items.add(item);
		
		when(orderDAO.readAllCustomers()).thenReturn(customers);
		when(utils.getLong()).thenReturn(customerId);
		when(orderDAO.create(any(Order.class))).thenReturn(created);
		when(orderDAO.readAllItems()).thenReturn(items);
		
		when(orderDAO.readItem(any(Long.class))).thenReturn(item);
		when(utils.getString()).thenReturn("n");
		
		assertEquals(created, orderController.create());
	}
	
	@Test
	public void testReadAll() {
		final Long customerId = 1L;
		final Long orderId = 1L;
		
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "FIFA", 11L, 39.99));
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(customerId, "john", "smith"));
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(orderId, customerId));
		
		when(orderDAO.readAll()).thenReturn(orders);
		
		assertEquals(orders, orderController.readAll());
	}
	
	@Test
	public void testDelete() {
		final long orderID = 1L;
		when(utils.getLong()).thenReturn(orderID);
		when(orderDAO.delete(orderID)).thenReturn(1);
		assertEquals(1, this.orderController.delete());
	}
	
	@Test
	public void testDeleteItem() {
		final long orderID = 1L;
		final long itemID = 1L;
		when(utils.getLong()).thenReturn(itemID);
		when(orderDAO.deleteItem(orderID, itemID)).thenReturn(1);
		assertEquals(1L, this.orderController.deleteItem(itemID));
	}
	
//	@Test
//	public void testUpdate() {
//		final Long customerId = 1L;
//		final Long itemId = 1L;
//		final Long orderId = 1L;
//		
//		List<Customer> customers = new ArrayList<>();
//		customers.add(new Customer(customerId, "john", "smith"));
//		
//		List<Item> items = new ArrayList<>();
//		Item item = new Item(itemId, "FIFA", 11L, 39.99);
//		items.add(item);
//		
//		List<Order> orders = new ArrayList<>();
//		Order order = new Order(orderId, customerId, items);
//		orders.add(order);
//		
//		List<Order> updatedOrders = new ArrayList<>();
//		items.add(new Item(itemId, "FIFA", 11L, 39.99));
//		updatedOrders.add(new Order(orderId, customerId, items));
//		
//		
//		when(orderController.readAll()).thenReturn(orders);
//		when(utils.getLong()).thenReturn(orderId);
//		when(utils.getString()).thenReturn("add");
//		when(utils.getLong()).thenReturn(itemId, 12L);
//		when(orderDAO.readItem(itemId)).thenReturn(item);
//		when(orderDAO.readItem(any(Long.class))).thenReturn(item);
//		when(utils.getString()).thenReturn("n");
//		assertEquals(updatedOrders, orderController.update());
//	}

	
}
