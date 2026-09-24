package com.gzz.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	@Bean("db1")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource db1() {
		return DataSourceBuilder.create().build();
	}

	@Bean("db2")
	@ConfigurationProperties(prefix = "custom.datasource")
	public DataSource db2() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean("dataSource")
	public DataSource dataSource() {
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(Map.of("db1", db1(), "db2", db2()));
		dataSource.setDefaultTargetDataSource(db1());
		dataSource.afterPropertiesSet();
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}