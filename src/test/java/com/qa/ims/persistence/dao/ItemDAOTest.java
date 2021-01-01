package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();
	final Item created1 = new Item(1L,"GTA", 50L, 29.99);
	final Item created2 = new Item(2L,"PUBG", 60L, 39.99);

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
		final Item created3 = new Item(3L, "Fortnite", 30L, 20.99);
		assertEquals(created3, DAO.create(created3));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L,"GTA", 50L, 29.99));
		expected.add(new Item(2L,"PUBG", 60L, 39.99));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(2L,"PUBG", 60L, 39.99), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 2L;
		assertEquals(new Item(2L,"PUBG", 60L, 39.99), DAO.readItem(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L,"FIFA", 20L, 69.99);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
