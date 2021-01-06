package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class ItemTest {

	private Item item = new Item(1L, "FIFA", 10L, 19.99);
	
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
		item.setId(2L);
		Item expected = new Item(2L, "FIFA", 10L, 19.99);
		assertEquals(expected, item);
	}
	
	@Test
	public void testSetItemName() {
		item.setItemName("COD");
		Item expected = new Item(1L, "COD", 10L, 19.99);
		assertEquals(expected, item);
	}
	
	@Test
	public void testSetQuantity() {
		item.setQuantity(35L);
		Item expected = new Item(1L, "FIFA", 35L, 19.99);
		assertEquals(expected, item);
	}
	
	@Test
	public void testSetPrice() {
		item.setPrice(35.99);
		Item expected = new Item(1L, "FIFA", 35L, 35.99);
		assertEquals(expected, item);
	}
	
}
