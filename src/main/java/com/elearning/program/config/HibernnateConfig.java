package com.elearning.program.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernnateConfig {

  @Autowired
  private Environment environment;

  @Bean
  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName(environment.getProperty("mysql.driver"));
    driverManagerDataSource.setUrl(environment.getProperty("mysql.url"));
    driverManagerDataSource.setUsername(environment.getProperty("mysql.username"));
    driverManagerDataSource.setPassword(environment.getProperty("mysql.password"));
    return driverManagerDataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactoryBean() {
    LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
    bean.setDataSource(dataSource());
    bean.setPackagesToScan(environment.getProperty("hibernate.package_scan"));

    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
    bean.setHibernateProperties(properties);
    return bean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
    return hibernateTransactionManager;
  }

}
