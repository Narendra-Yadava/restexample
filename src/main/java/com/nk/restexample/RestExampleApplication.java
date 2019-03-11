package com.nk.restexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RestExampleApplication extends SpringBootServletInitializer {

	private final static Logger LOGGER = LoggerFactory.getLogger(RestExampleApplication.class);

	/**
	 * This method is used to configure RestExampleApplication
	 * 
	 * @param application
	 * 
	 */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.debug("RestExampleApplication SpringApplicationBuilder start");
		return application.sources(RestExampleApplication.class);

	}

	public static void main(String[] args) {
		LOGGER.info("RestExampleApplication Startup context configuration start.......");
		SpringApplication.run(RestExampleApplication.class, args);
		LOGGER.info("RestExampleApplication Startup context configuration end.......");

	}

}
