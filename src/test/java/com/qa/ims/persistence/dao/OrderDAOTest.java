package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final ItemDAO itemDAO = new ItemDAO();
	private final CustomerDAO custDAO = new CustomerDAO();
	private final OrderDAO DAO = new OrderDAO(itemDAO);
	final Order created1 = new Order(1L);
	final Customer customer1 = new Customer(1L, "john", "smith");
	final Customer customer2 = new Customer(2L, "ben", "johnson");
	final Item item1 = new Item(1L, "GTA", 50L, 19.99);

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		custDAO.create(customer1);
		DAO.create(created1);
		itemDAO.create(item1);
		DAO.createOrderline(1L, 1L);
	}
	 
	@Test
	public void testCreate() {
		final Order order = new Order(1L);
		final Order expected = new Order(2L, 1L);
		assertEquals(expected, DAO.create(order));
	}
	
	@Test
	public void testCreateFAIL() {
		assertNull(DAO.create(new Order(5L)));
	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L ,"GTA", 50L, 19.99));
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, items));
		assertEquals(expected, DAO.readAll());
	}
	
//	@Test
//	public void testReadAllFAIL() {
//		DAO.deleteOrderline(1L);
//		DAO.delete(1L);
//		assertNull(DAO.readAll());
//	}
	
	@Test
	public void testReadLatest() {
		itemDAO.create(new Item(2L ,"Warcraft", 60L, 12.99));
		DAO.create(new Order(1L));
		DAO.createOrderline(2L, 2L);
		List<Item> items = new ArrayList<>();
		items.add(new Item(2L ,"Warcraft", 60L, 12.99));
		Order expected = new Order(2L, 1L, items);
		assertEquals(expected, DAO.readLatest());
	}
	
	@Test
	public void testReadLatestFAIL() {
		DAO.deleteOrderline(1L);
		DAO.delete(1L);
		assertNull(DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L ,"GTA", 50L, 19.99));
		assertEquals(new Order(1L, ID, items), DAO.readOrder(ID));
	}
	
	@Test
	public void testReadOrderFAIL() {
		assertNull(DAO.readOrder(2L));
	}
	
	@Test
	public void testUpdate() {
		custDAO.create(customer2);
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L ,"GTA", 50L, 19.99));
		Order updated = new Order(1L, 2L);
		Order expected = new Order(1L, 2L, items);
		assertEquals(expected, DAO.update(updated));
	}
	
//	@Test
//	public void testUpdateFAIL() {
//		Order updated = new Order(5L, 5L);
//		assertNull(DAO.update(updated));
//	}
	
//	@Test
//	public void testReadOrderlineFAIL() {
//		DAO.deleteOrderline(1L);
//		DAO.delete(1L);
//		assertNull(DAO.readOrderline(1L));
//	}
	
	@Test
	public void testCreateOrderline() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L ,"GTA", 50L, 19.99));
		items.add(new Item(1L ,"GTA", 50L, 19.99));
		Order expected = new Order(1L, 1L, items);
		assertEquals(expected, DAO.createOrderline(expected.getOrder_id(), 1L));
	}
	
	@Test
	public void testCreateOrderlineFAIL() {
		assertNull(DAO.createOrderline(2L, 2L));
	}
	
	@Test
	public void testDeleteOrderline() {
		assertEquals(1, DAO.deleteOrderline(1));
	}
	
//	@Test
//	public void testDeleteOrderlineFAIL() {
//		assertNull(DAO.deleteOrderline(2));
//	}
	
	@Test
	public void testDelete() {
		DAO.create(new Order(1L));
		assertEquals(1, DAO.delete(1));
	}
	
//	@Test
//	public void testDeleteFAIL() {
//		assertNull(DAO.delete(2L));
//	}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.deleteItem(1L, 1L));
	}
	
//	@Test
//	public void testDeleteItemFAIL() {
//		assertNull(DAO.deleteItem(0L, 0L));
//	}
	
}
