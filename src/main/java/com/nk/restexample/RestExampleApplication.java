package com.nk.restexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestExampleApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(RestExampleApplication.class);

	public static void main(String[] args) {
		LOGGER.info("RestExampleApplication Startup context configuration start.......");
		SpringApplication.run(RestExampleApplication.class, args);
		LOGGER.info("RestExampleApplication Startup context configuration end.......");

	}

}
