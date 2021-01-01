package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final ItemDAO itemDAO = new ItemDAO();
	private final CustomerDAO custDAO = new CustomerDAO();
	private final OrderDAO DAO = new OrderDAO(itemDAO, custDAO);
	final Long cust_id1 = 1L;
	final Long cust_id2 = 2L;
	final Order created1 = new Order(1L);
	final Order created2 = new Order(2L);
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		DAO.create(created1);
		DAO.create(created2);
	}
	
	@Test
	public void testCreate() {
		final Order created3 = new Order(3L);
		assertEquals(created3, DAO.create(created3));
	}
	
}
