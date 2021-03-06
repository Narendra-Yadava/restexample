/***************************************************************************
 *  Copyright (C) Proximus 2019
 *
 *  The reproduction, transmission or use of this document  or its contents
 *  is not  permitted without  prior express written consent of Proximus.
 *  Offenders will be liable for damages. All rights, including  but not 
 *  limited to rights created by patent grant or registration of a utility
 *  model or design, are reserved.
 *
 *  Proximus reserves the right to modify technical specifications and features.
 *
 *  Technical specifications and features are binding only in so far as they
 *  are specifically and expressly agreed upon in a written contract.
 *
 **************************************************************************/
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
