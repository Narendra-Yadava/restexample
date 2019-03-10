
package com.nk.restexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *  WebMVCConf.java
 *
 * @author Narendra.Kumar
 *
 * @date Mar 10, 2019
 *
 */
@Configuration
public class WebMVCConf {

	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
