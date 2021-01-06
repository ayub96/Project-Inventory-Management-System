package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTestFAIL {
	
	private final CustomerDAO DAO = new CustomerDAO();
	final Customer created1 = new Customer(1L,"chris", "perrins");
	final Customer created2 = new Customer(2L,"jordan", "harrison");
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "FAIL");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		DAO.create(created1);
		DAO.create(created2);
	}
	
	@Test
	public void testReadCustomerFAIL() {
		assertNull(DAO.readCustomer(5L));
	}
	
	@Test
	public void testReadAllFAIL() {
		List<Customer> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatestFAIL() {
		DAO.delete(1L);
		DAO.delete(2L);
		assertNull(DAO.readLatest());
	}
	
	@Test
	public void testUpdateFAIL() {
		final Customer updated = new Customer(1L, "harry", "potter");
		assertNull(DAO.update(updated));
		
	}
	
}
