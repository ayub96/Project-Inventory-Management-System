package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class OrderTest {
	
	private Order order = new Order(1L, 1L);
	private List<Item> items = new ArrayList<>();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testSetId() {
		order.setOrder_id(2L);
		Order expected = new Order(2L, 1L);
		assertEquals(expected, order);
	}
	
	@Test
	public void testCustomerId() {
		order.setCustomer_id(2L);
		Order expected = new Order(1L, 2L);
		assertEquals(expected, order);
	}
	
	@Test
	public void testToString() {
		Item item = new Item(1L, "COD", 25L, 29.99);
		items.add(item);
		String myItem = item.toOrderString() + "\n";
		Order order = new Order(2L, 1L, items);
		String expected = "[order ID]: " + 2L 
						+ "\n [customer ID]: " + 1L
						+ "\n [items]:\n" + myItem 
						+ " [Total]: " + 29.99;
		assertEquals(expected, order.toString());
	}
	
	@Test
	public void testEqual() {
		Order order = new Order(1L);
		Order myOrder = new Order(1L);
		boolean isEqual = order.equals(myOrder);
		boolean expected = true;
		assertEquals(expected, isEqual);
	}
	
	@Test
	public void testNotEqual() {
		Order order = new Order(2L);
		Order myOrder = new Order(1L);
		boolean isEqual = order.equals(myOrder);
		boolean expected = false;
		assertEquals(expected, isEqual);
	}
	
}
