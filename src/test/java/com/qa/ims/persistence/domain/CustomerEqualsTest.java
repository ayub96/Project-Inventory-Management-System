package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;

public class CustomerEqualsTest {

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void IdEqualFalse() {
		Customer customerA = new Customer(1L, "john", "smith");
		Customer customerB = new Customer(2L, "john", "smith");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void IdNullEqualFalse() {
		Customer customerA = new Customer(null, "john", "smith");
		Customer customerB = new Customer(2L, "john", "smith");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void fNameEqualFalse() {
		Customer customerA = new Customer(1L, "john", "smith");
		Customer customerB = new Customer(1L, "bob", "smith");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void fNameNullEqualFalse() {
		Customer customerA = new Customer(1L, null, "smith");
		Customer customerB = new Customer(1L, "bob", "smith");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void sNameEqualFalse() {
		Customer customerA = new Customer(1L, "john", "smith");
		Customer customerB = new Customer(1L, "john", "robinson");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void sNameNullEqualFalse() {
		Customer customerA = new Customer(1L, "john", null);
		Customer customerB = new Customer(1L, "john", "robinson");
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void nullEqualFalse() {
		Customer customerA = new Customer(1L, "john", "smith");
		Customer customerB = null;
		boolean expected = false;
		assertEquals(expected, customerA.equals(customerB));
	}
	
	@Test
	public void classEqualFalse() {
		Customer customerA = new Customer(1L, "john", "smith");
		Item item = new Item(1L, "FIFA", 45L, 19.99);
		boolean expected = false;
		assertEquals(expected, customerA.equals(item));
	}
	
	
}
