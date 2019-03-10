package com.nk.restexample;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*@Configuration
@ComponentScan(basePackages = { "com.nk.restexample.*" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.nk.restexample.config.*"),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DBConfiguration.class) })

@RunWith(SpringRunner.class)
@SpringBootTest
*/
public class RestexampleApplicationTests {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Bean
	protected DataSource dataSource() {
		return Mockito.mock(DataSource.class);
	}

	@Bean
	protected JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}

	@Bean
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return Mockito.mock(NamedParameterJdbcTemplate.class);
	}

	//@Test
	public void contextLoads() {
		LOGGER.info("Spring context loaded successfully......");
	}

}
