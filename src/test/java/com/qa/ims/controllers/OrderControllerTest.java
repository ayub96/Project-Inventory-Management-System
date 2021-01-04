//package com.qa.ims.controllers;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.ims.controller.OrderController;
//import com.qa.ims.persistence.dao.CustomerDAO;
//import com.qa.ims.persistence.dao.OrderDAO;
//import com.qa.ims.persistence.domain.Order;
//import com.qa.ims.utils.Utils;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrderControllerTest {
//	
//	@Mock
//	private Utils utils;
//	
//	@Mock
//	private OrderDAO orderDAO;
//	
//	@InjectMocks
//	private OrderController orderController;
//	
////	@Test
////	public void testCreate() {
////		final long CUSTOMER_ID = 1L;
////		final Order created = new Order(1l, CUSTOMER_ID);
////		final String secondAnswer = "no";
////		final long ITEM_ID = 1L;
////
////
////		Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, 1L,ITEM_ID);
////		Mockito.when(utils.getString()).thenReturn(secondAnswer);
////		Mockito.when(orderDAO.create(any(Order.class))).thenReturn(created);
////		Mockito.when(orderDAO.readLatest()).thenReturn(created);
////		
////		assertEquals(created, orderController.create());
////
////		Mockito.verify(utils, Mockito.times(1)).getString();
////		Mockito.verify(utils, Mockito.times(2)).getLong();
////		Mockito.verify(orderDAO, Mockito.times(1)).create(any(Order.class));
////	}
//
//	@Test
//	public void testReadAll() {
//		List<Order> orders = new ArrayList<>();
//		orders.add(new Order(1L, 1L));
//
//		Mockito.when(orderDAO.readAll()).thenReturn(orders);
//
//		assertEquals(orders, orderController.readAll());
//
//		Mockito.verify(orderDAO, Mockito.times(1)).readAll();
//	}
//
//	@Test
//	public void testCreate() {
//		Order updated = new Order(1L, 2L);
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getCustomer_id());
//		Mockito.when(this.utils.getLong()).thenReturn("yes", "no");
//		Mockito.when(this.orderDAO.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.orderController.update());
//
//		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.orderDAO, Mockito.times(1)).update(updated);
//	}
//
//	@Test
//	public void testDelete() {
//		final long ID = 2L;
//
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(orderDAO.delete(ID)).thenReturn(2);
//
//		assertEquals(2L, this.orderController.delete());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(orderDAO, Mockito.times(1)).delete(ID);
//	}
//	
//}
