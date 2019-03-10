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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

	@Autowired
	private RestTemplate restTemplate;

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

	@GetMapping("/getData")
	public List<Map<String, Object>> getData() {
		logger.info("getData ++");
		List<Map<String, Object>> list = companyDAO.getCompanyProperties();
		logger.info("getDatalist size : " + list.size());
		logger.info("getData --");

		return list;
	}

	@GetMapping("/getOSRestData")
	public Object[] getOSRestData() {
		logger.info("getOSRestData ++");
		String url = "http://restexample-restexample.1d35.starter-us-east-1.openshiftapps.com/rest/getData";
		logger.info("openshift url --" + url);
		ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
		logger.info("getOSRestData list size : " + response.getBody());
		logger.info("getOSRestData --");
		return response.getBody();

	}

	@GetMapping("/getOSHi")
	public String getOSHi() {
		logger.info("getOSHi ++");
		String url = "http://restexample-restexample.1d35.starter-us-east-1.openshiftapps.com/rest/hi";
		logger.info("openshift url --" + url);
		ResponseEntity<String> hiStr = restTemplate.getForEntity(url, String.class);
		logger.info("getOSHi --" + hiStr.getBody());
		return hiStr.getBody();

	}
}

