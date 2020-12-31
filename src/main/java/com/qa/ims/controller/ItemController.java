package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

//Takes in Item details for CRUD functionality

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();	// ???what does super() do here???
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {				// gets a list of items from the DAO which gets the items from the database!
		List<Item> items = itemDAO.readAll();	// readAll() is a method from the itemDAO!
		for(Item item : items) {				// print out the list the itemDAO gave me!
			LOGGER.info(item.toString());		// the toString method is called from the item class! Prints it nicely
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter the item name!");
		String itemName = utils.getString();		// getString() is a method in our utils class, it returns next line!
		LOGGER.info("Please enter the quantity of the item!");
		Long itemQuantity = utils.getLong();
		LOGGER.info("Please enter the item price!");
		double itemPrice = utils.getDouble();
		Item item = itemDAO.create(new Item(itemName, itemQuantity, itemPrice));
		LOGGER.info("Item created!");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter an item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the item quantity");
		Long itemQuantity = utils.getLong();
		LOGGER.info("Please enter the item price");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.update(new Item(id, itemName, itemQuantity, itemPrice));
		LOGGER.info("Item Updated!");
		return item;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the item id (NOTE: any orderlines containing the item will also be deleted):");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}
}
