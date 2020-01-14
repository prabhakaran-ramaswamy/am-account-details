package org.sample.capstone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CapstoneConfiguration {
	/*
	@Autowired
	private DataSource dataSource;

	@Bean
	@Primary
	public DataSourceHealthIndicator dataSourceHealthIndicator() {
	    return new DataSourceHealthIndicator(dataSource, "SELECT 1");
	}

	@Bean
	public HealthIndicator dbHealthIndicator() {
	    DataSourceHealthIndicator indicator = new DataSourceHealthIndicator(dataSource);
	    indicator.setQuery("SELECT 1");
	    return indicator;
	}*/
}
