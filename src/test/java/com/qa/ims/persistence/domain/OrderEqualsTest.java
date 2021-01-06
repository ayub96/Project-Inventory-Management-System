package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class OrderEqualsTest {
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testEqualObjects() {
		Order orderA = new Order(1L);
		assertTrue(orderA.equals(orderA));
	}
	
	@Test
	public void testSameObject() {
		Order orderA = new Order(1L);
		Order orderB = new Order(1L);
		assertTrue(orderA.equals(orderB));
	}
	
//	@Test
//	public void testEqualsFalse() {
//		Item item = new Item(1L, "FIFA", 35L, 35.99);
//		Item myItem = new Item(2L, "FIFA", 35L, 35.99);
//		assertEquals(false, item.equals(myItem));
//	}
	
	@Test
	public void custIdEqualFalse() {
		Order orderA = new Order(1L);
		Order orderB = new Order(2L);
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void custIdNullEqualFalse() {
		Order orderA = new Order(null);
		Order orderB = new Order(2L);
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void ordIdEqualFalse() {
		Order orderA = new Order(1L, 1L);
		Order orderB = new Order(2L, 1L);
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void ordIdNullEqualFalse() {
		Order orderA = new Order(null, 1L);
		Order orderB = new Order(2L, 1L);
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void objNullEqualFalse() {
		Order orderA = new Order(null, 1L);
		Order orderB = null;
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void classEqualFalse() {
		Order order = new Order(1L, 1L);
		Item item = new Item(2L, "FIFA", 10L, 19.99);
		assertFalse(order.equals(item));
	}
	
	@Test
	public void itemIdNullEqualFalse() {
		List<Item> itemsA = new ArrayList<>();
		itemsA = null;
		List<Item> itemsB = new ArrayList<>();
		itemsB.add(new Item(2L, "FIFA", 10L, 19.99));
		Order orderA = new Order(1L, 1L, itemsA);
		Order orderB = new Order(1L, 1L, itemsB);
		assertFalse(orderA.equals(orderB));
	}
	
	@Test
	public void itemEqualFalse() {
		List<Item> itemsA = new ArrayList<>();
		itemsA.add(new Item(1L, "COD", 15L, 17.99));
		Order orderA = new Order(1L, 1L, itemsA);
		
		List<Item> itemsB = new ArrayList<>();
		itemsB.add(new Item(2L, "FIFA", 10L, 19.99));
		Order orderB = new Order(2L, 2L, itemsB);
		
		assertFalse(orderB.equals(itemsA));
	}
	
	
//	@Test
//	public void nameEqualFalse() {
//		Item itemA = new Item(1L, "COD", 35L, 35.99);
//		Item itemB = new Item(1L, "FIFA", 35L, 35.99);
//		assertEquals(false, itemA.equals(itemB));
//	}
//	
//	@Test
//	public void nameNullEqualFalse() {
//		Item itemA = new Item(1L, null, 35L, 35.99);
//		Item itemB = new Item(1L, "FIFA", 35L, 35.99);
//		assertEquals(false, itemA.equals(itemB));
//	}
//	
//	@Test
//	public void nullEqualFalse() {
//		Item itemA = new Item(1L, null, 35L, 35.99);
//		Item itemB = null;
//		assertEquals(false, itemA.equals(itemB));
//	}
//	
//	@Test
//	public void classEqualFalse() {
//		Item item = new Item(1L, "FIFA", 45L, 19.99);
//		Customer customerA = new Customer(1L, "john", "smith");
//		assertEquals(false, item.equals(customerA));
//	}
//	
//	@Test
//	public void empty() {
//		Item item = new Item(1L, "FIFA", 45L, 19.99);
//		Customer customerA = new Customer(1L, "john", "smith");
//		assertEquals(true, item.equals(customerA));
//	}
	
	
}
