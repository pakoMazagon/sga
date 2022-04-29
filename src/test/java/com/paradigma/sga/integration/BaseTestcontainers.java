package com.paradigma.sga.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import com.paradigma.sga.domain.repository.PricesRepository;

public class BaseTestcontainers {

	static final MySQLContainer mySQLContainer;
	
	@Autowired
	PricesRepository priceRepository;

    static {
    	mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:8.0")
        	.withDatabaseName("db_inditext")
            .withUsername("root")
            .withPassword("admin")
                .withReuse(true);

    	mySQLContainer.start();
    }

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
    }
}
