package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;
	private Utils utils;

	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	@Override
	public List<Customer> readAll() {
		LOGGER.info("");
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	@Override
	public Customer create() {
		LOGGER.info("\nPlease enter a first name");
		String firstName = utils.getString();
		LOGGER.info("\nPlease enter a surname");
		String surname = utils.getString();
		Customer customer = customerDAO.create(new Customer(firstName, surname));
		LOGGER.info("\nCustomer created");
		return customer;
	}

	@Override
	public Customer update() {
		readAll();
		LOGGER.info("\nPlease enter the id of the customer you would like to update:");
		Long id = utils.getLong();
		LOGGER.info("\nPlease enter a first name");
		String firstName = utils.getString();
		LOGGER.info("\nPlease enter a surname");
		String surname = utils.getString();
		Customer customer = customerDAO.update(new Customer(id, firstName, surname));
		LOGGER.info("\nCustomer Updated");
		return customer;
	}

	@Override
	public int delete() {
		readAll();
		LOGGER.info("\nPlease enter the customer id (NOTE: Please delete all orders containing the customer first):");
		Long id = utils.getLong();
		return customerDAO.delete(id);
	}

}
