package com.sandeepkamathkr.microservices.mycurrencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MyCurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCurrencyExchangeServiceApplication.class, args);
	}

}
