package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class ItemEqualsTest {
	
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
		Item item = new Item(1L, "FIFA", 35L, 35.99);
		Item itemB = new Item(1L, "FIFA", 35L, 35.99);
		assertEquals(true, item.equals(itemB));
	}
	
	@Test
	public void testSameObject() {
		Item item = new Item(1L, "FIFA", 35L, 35.99);
		assertEquals(true, item.equals(item));
	}
	
	@Test
	public void testEqualsFalse() {
		Item item = new Item(1L, "FIFA", 35L, 35.99);
		Item myItem = new Item(2L, "FIFA", 35L, 35.99);
		assertEquals(false, item.equals(myItem));
	}
	
	@Test
	public void IdEqualFalse() {
		Item itemA = new Item(1L, "FIFA", 35L, 35.99);
		Item itemB = new Item(2L, "FIFA", 35L, 35.99);
		assertEquals(false, itemA.equals(itemB));
	}
	
	@Test
	public void IdNullEqualFalse() {
		Item itemA = new Item(null, "FIFA", 35L, 35.99);
		Item itemB = new Item(2L, "FIFA", 35L, 35.99);
		assertEquals(false, itemA.equals(itemB));
	}
	
	@Test
	public void nameEqualFalse() {
		Item itemA = new Item(1L, "COD", 35L, 35.99);
		Item itemB = new Item(1L, "FIFA", 35L, 35.99);
		assertEquals(false, itemA.equals(itemB));
	}
	
	@Test
	public void nameNullEqualFalse() {
		Item itemA = new Item(1L, null, 35L, 35.99);
		Item itemB = new Item(1L, "FIFA", 35L, 35.99);
		assertEquals(false, itemA.equals(itemB));
	}
	
	@Test
	public void nullEqualFalse() {
		Item itemA = new Item(1L, null, 35L, 35.99);
		Item itemB = null;
		assertEquals(false, itemA.equals(itemB));
	}
	
	@Test
	public void classEqualFalse() {
		Item item = new Item(1L, "FIFA", 45L, 19.99);
		Customer customerA = new Customer(1L, "john", "smith");
		assertEquals(false, item.equals(customerA));
	}
	
	
}
