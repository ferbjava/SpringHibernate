package com.ferb.crm.rest.demo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.ferb.crm.rest.demo")
@PropertySource({"classpath:persistence-mysql.properties"})
public class DemoAppConfig {

	
	@Autowired
	private Environment env;
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			// dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		LOGGER.info("jdbc.url= " + env.getProperty("jdbc.url"));
		LOGGER.info("jdbc.user= " + env.getProperty("jdbc.user"));
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProps());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory session) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(session);
		
		return txManager;
	}
	
	private Properties getHibernateProps() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		return Integer.parseInt(propVal);
	}
}
