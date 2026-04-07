package com.ecommerce.salesforce_ingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SalesforceIngestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesforceIngestionApplication.class, args);
	}

}
