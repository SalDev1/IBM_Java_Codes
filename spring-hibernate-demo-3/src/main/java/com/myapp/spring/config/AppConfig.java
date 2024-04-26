package com.myapp.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan()
public class AppConfig {
	
	// To interact with DB , we do this. 
	// We are going to create a connection pool.
	
	// This helps you in creating database connection pool.
	
	@Bean
	
	// DataSource is an interface , we get this multiple vendors.
	// Multiple vendors give implementation
	// which gives DBCP + HikariDataSource.
	
	DataSource dataSource() {
		// Connection Pool --> We use HikariDataSource.
		HikariDataSource dataSource = new HikariDataSource();
		
		// Driver Connecting to Java to DB and DB to Java
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		// Type-4 Driver --> Pure Java Driver(jdbc::) , It uses the native protocol of the database.
		// MySQL --> SubProtocol.
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudfsd");
		dataSource.setUsername("root");
		dataSource.setPassword("pass");
		
		// Every operation must go through the Transaction. 
		// Understanding how AOP works.
		dataSource.setAutoCommit(false);
		
		// Setting the size of the connection pool as 10.
		// Cutting a connection is always costlier 
		// , that's why we pre-configure it.
		dataSource.setMaximumPoolSize(10);
		// returning an interface.
		return dataSource;
	}
	
	@Bean
	// Injecting our data-source + This is our dependency injection.
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	
		emf.setDataSource(datasource);
		emf.setPackagesToScan("com.myapp.spring.domain");
		
		// WHO IS HELL IS OUR ENGINE / IN SIMPLE WORDS OUR VENDOR.
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return emf;
	}
}
