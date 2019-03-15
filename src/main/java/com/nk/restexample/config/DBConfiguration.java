/***************************************************************************
 *  Copyright (C) Proximus 2018
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

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiTemplate;

/**
 * This class is used to configure the data source and JDBC template using JNDI.
 * 
 * @author Narendra.Kumar
 *
 * @date Nov 13, 2018
 *
 */
@Configuration
public class DBConfiguration {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/*@Value("${spring.datasource.jndi-name}")
	private String databaseJndi;

	@Bean
	public DataSource dataSource() throws RuntimeException, NamingException {
		LOGGER.debug("DataSource configuration.......");
		return (DataSource) new JndiTemplate().lookup(databaseJndi);
	}*/

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) throws NamingException {
		LOGGER.debug("JdbcTemplate configuration start +");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.debug("JdbcTemplate configuration end -");
		return jdbcTemplate;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) throws NamingException {
		LOGGER.debug("namedParameterJdbcTemplate bean creation ....");
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
