package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();
	final Customer created1 = new Customer(1L,"chris", "perrins");
	final Customer created2 = new Customer(2L,"jordan", "harrison");
	
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
		final Customer created3 = new Customer(3L,"michael", "jackson");
		assertEquals(created3, DAO.create(created3));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "chris", "perrins"));
		expected.add(new Customer(2L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Customer(2L, "jordan", "harrison"), DAO.readLatest());
	}


	@Test
	public void testRead() {
		final long ID = 2L;
		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.readCustomer(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "harry", "potter");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
}
