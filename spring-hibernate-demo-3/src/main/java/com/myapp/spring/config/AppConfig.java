package com.myapp.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages="com.myapp.spring")
@EnableTransactionManagement 
public class AppConfig {
	
	// To interact with DB , we do this. 
	// We are going to create a connection pool.
	
	// This helps you in creating database connection pool.
	
	// DataSource is an interface , we get this multiple vendors.
	// Multiple vendors give implementation
	// which gives DBCP + HikariDataSource
	
	@Bean
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
		// Cutting a connection and creating it again is always costlier 
		// , that's why we pre-configure it.
		dataSource.setMaximumPoolSize(10);
		
		// returning an interface.
		return dataSource;
	}
	
	// Injecting our data-source + This is our dependency injection.
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
		// Spring provider class to manage an entity --> LocalContainerEntityManagerFactoryBean
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	
		emf.setDataSource(datasource);
		emf.setPackagesToScan("com.myapp.spring.domain");  // Which classes are we scanning ? 
		
		// WHO IS HELL IS OUR ENGINE / IN SIMPLE WORDS OUR VENDOR.
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties()); // Setting the jpaProperities.  

		return emf;
	}
	
	// Auto Create a Table.
	Properties jpaProperties() {
	   Properties props = new Properties();
	   props.put("hibernate.hbm2ddl.auto", "update"); // Maps from HiberNate to DDL. 
	   // update given us two permissions --> Create & Alter the table.
	   // create --> create a table.
	   // drop --> drops the table.
	   props.put("hibernate.show_sql","true"); // Based on the entity class , it auto-generate all the tables.
	   
	   return props;
	}
	
	
	// Transactions are part of Spring Aspect + defines the single point of entry too. 
	// PlatformTransactionManager --> helps you handle the transactions / entities.
	@Bean   // Aspect Class for managing transactions.
	PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
