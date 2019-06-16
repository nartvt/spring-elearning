package com.elearning.program.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernnateConfig {
	 private static final String MYSQL_DRIVER_CLASS_NAME ="com.mysql.jdbc.Driver";
	    private static final String MYSQL_HOST = "localhost";
	    private static final String MYSQL_URL = "jdbc:mysql://" + MYSQL_HOST + ":3306/springelearning?autoReconnect=true&useSSL=false";
	    private static final String MYSQL_USER_NAME = "root";
	    private static final String MYSQL_USER_PASSWORD = "root";
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(MYSQL_DRIVER_CLASS_NAME);
		driverManagerDataSource.setUrl(MYSQL_URL);
		driverManagerDataSource.setUsername(MYSQL_USER_NAME);
		driverManagerDataSource.setPassword(MYSQL_USER_PASSWORD);
		return driverManagerDataSource;		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.elearning.program.entity");

		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql",true);
		bean.setHibernateProperties(properties);
		return bean;
	}
	
}
