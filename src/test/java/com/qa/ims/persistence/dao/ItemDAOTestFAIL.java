package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTestFAIL {

	private final ItemDAO DAO = new ItemDAO();
	final Item created1 = new Item(1L,"GTA", 50L, 29.99);
	final Item created2 = new Item(2L,"PUBG", 60L, 39.99);
	
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
	public void testReadLatestFAIL() {
		DAO.delete(1L);
		DAO.delete(2L);
		assertNull(DAO.readLatest());
	}
	
	@Test
	public void testReadItemFAIL() {
		assertNull(DAO.readItem(5L));
	}
	
	@Test
	public void testUpdateFAIL() {
		final Item updated = new Item(1L,"FIFA", 20L, 69.99);
		assertNull(DAO.update(updated));
	}
	
	@Test
	public void testReadAllFAIL() {
		List<Item> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
	
}
