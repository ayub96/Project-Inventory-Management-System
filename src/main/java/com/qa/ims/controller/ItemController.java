package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;


public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		LOGGER.info("");
		List<Item> items = itemDAO.readAll();
		for(Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("\nPlease enter the item name:");
		String itemName = utils.getString();
		LOGGER.info("\nPlease enter the item stock:");
		Long itemQuantity = utils.getLong();
		LOGGER.info("\nPlease enter the item price:");
		double itemPrice = utils.getDouble();
		Item item = itemDAO.create(new Item(itemName, itemQuantity, itemPrice));
		LOGGER.info("\nItem created!");
		return item;
	}

	@Override
	public Item update() {
		readAll();
		LOGGER.info("\nPlease enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("\nPlease enter an item name");
		String itemName = utils.getString();
		LOGGER.info("\nPlease enter the item stock");
		Long itemQuantity = utils.getLong();
		LOGGER.info("\nPlease enter the item price");
		Double itemPrice = utils.getDouble();
		Item item = itemDAO.update(new Item(id, itemName, itemQuantity, itemPrice));
		LOGGER.info("\nItem Updated!");
		return item;
	}
	
	@Override
	public int delete() {
		LOGGER.info("\nPlease enter the item id (NOTE: any orderlines containing the item will also be deleted):");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}
}
