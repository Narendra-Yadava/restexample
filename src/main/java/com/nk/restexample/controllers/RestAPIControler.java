/**
 * 
 */
package com.nk.restexample.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Narendra.kumar
 *
 */
@RestController
@RequestMapping(value = { "/rest" })
public class RestAPIControler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CompanyDAO companyDAO;

	@GetMapping("/hi")
	public String getName() {
		MDC.put("userId", "Narendra Yadav");

		String res = "Hi Narendra Yadav";
		logger.info("res : " + res);
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");

		MDC.remove("userId");

		return res;
	}

	@GetMapping("/companyDetail")
	public List<Map<String, Object>> getCompanyDetail() {
		MDC.put("userId", "Narendra Yadav");
		List<Map<String, Object>> list = companyDAO.getCompanyProperties();
		String res = "Hi Narendra Yadav";
		logger.info("res : " + res);
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");

		MDC.remove("userId");

		return list;
	}

}
