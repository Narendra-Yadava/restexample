/**
 * 
 */
package com.nk.restexample.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
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

	public String hostName = System.getenv().getOrDefault("HOSTNAME", "UNKNOWN");

	@GetMapping("/hi")
	public String getName() {
		MDC.put("userId", "Narendra Yadav");
		String localIPAdress = "";
		String localHostName = "";
		String remoteIPAdress = "";
		String remoteHostName = "";
		String str = "";
		try {

			// Local address
			localIPAdress = InetAddress.getLocalHost().getHostAddress();
			localHostName = InetAddress.getLocalHost().getHostName();
			// Remote address
			remoteIPAdress = InetAddress.getLoopbackAddress().getHostAddress();
			remoteHostName = InetAddress.getLoopbackAddress().getHostName();
			str = "Hi from localIPAdress : " + localIPAdress + " localHostName : " + localHostName
					+ " remoteIPAdress : " + remoteIPAdress + " remoteHostName : " + remoteHostName;
			logger.info(str);

		} catch (UnknownHostException e) {

			str = "Error from localIPAdress : " + localIPAdress + " localHostName : " + localHostName
					+ " remoteIPAdress : " + remoteIPAdress + " remoteHostName : " + remoteHostName + "error message : "
					+ e.getMessage();

			logger.error(str);

		}
		MDC.remove("userId");

		return str;
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
