package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class CustomerTest {

	private Customer customer = new Customer(1L, "robert", "peterson");
	
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
		customer.setId(2L);
		Customer expected = new Customer(2L, "robert", "peterson");
		assertEquals(expected, customer);
	}
	
	@Test
	public void testSetFirstName() {
		customer.setFirstName("william");
		Customer expected = new Customer(1L, "william", "peterson");
		assertEquals(expected, customer);
	}
	
	@Test
	public void testSetSurname() {
		customer.setSurname("smith");
		Customer expected = new Customer(1L, "robert", "smith");
		assertEquals(expected, customer);
	}
	
	@Test
	public void TestToOrderString() {
		String myCustomer = customer.toOrderString();
		String expected = customer.getFirstName() + " " + customer.getSurname();
		assertEquals(expected, myCustomer);
	}
	
}
