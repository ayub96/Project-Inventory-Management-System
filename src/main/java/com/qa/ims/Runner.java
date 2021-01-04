package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		IMS ims = new IMS();		// create a new IMS instance - but what is IMS?
		ims.imsSystem();			// Call imsSystem, our first method!
		LOGGER.info("SO LONG!");	// Main has run
		has_run();
	}

	public static boolean has_run() {
		return true;
	}
	
}
