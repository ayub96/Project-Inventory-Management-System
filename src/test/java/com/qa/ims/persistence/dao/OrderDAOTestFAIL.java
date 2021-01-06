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

public class OrderDAOTestFAIL {
	
	private final ItemDAO itemDAO = new ItemDAO();
	private final CustomerDAO custDAO = new CustomerDAO();
	private final OrderDAO DAO = new OrderDAO();
	final Order created1 = new Order(1L);
	final Customer customer1 = new Customer(1L, "john", "smith");
	final Customer customer2 = new Customer(2L, "ben", "johnson");
	final Item item1 = new Item(1L, "GTA", 50L, 19.99);
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "FAIL");
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
	public void testReadOrderlineFAIL() {
		DAO.deleteOrderline(1L);
		DAO.delete(1L);
		assertNull(DAO.readOrderline(1L));
	}
	
	@Test
	public void testUpdateFAIL() {
		Order updated = new Order(5L, 5L);
		assertNull(DAO.update(updated));
	}
	
	@Test
	public void testDeleteOrderlineFAIL() {
		assertEquals(0, DAO.deleteOrderline(2));
	}
	
	@Test
	public void testReadAllCustomersFAIL() {
		assertEquals(new ArrayList<>(), DAO.readAllCustomers());
	}
	
	@Test
	public void testReadItemFAIL() {
		final long ID = 2L;
		assertNull(DAO.readItem(ID));
	}
	
	@Test
	public void testDeleteFAIL() {
		assertEquals(0, DAO.delete(2L));
	}
	
	@Test
	public void testCreateOrderlineFAIL() {
		assertNull(DAO.createOrderline(2L, 2L));
	}
	
	@Test
	public void testUpdateItemFAIL() {
		final Item updated = new Item(1L,"FIFA", 20L, 69.99);
		assertNull(DAO.updateItem(updated));
	}
	
	@Test
	public void testReadAllItemsFAIL() {
		assertEquals(new ArrayList<>(), DAO.readAllItems());
	}
	
	@Test
	public void testDeleteItemFAIL() {
		assertEquals(0, DAO.deleteItem(0L, 0L));
	}
	
	@Test
	public void testReadAllFAIL() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
}
