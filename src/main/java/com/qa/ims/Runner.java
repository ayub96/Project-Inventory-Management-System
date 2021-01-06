package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();
	
	public static void main(String[] args) {
		IMS ims = new IMS();		// create a new IMS instance - but what is IMS?
		ims.imsSystem();			// Call imsSystem, our first method!
		LOGGER.info("SO LONG!");	// Main has run
	}
	
}
