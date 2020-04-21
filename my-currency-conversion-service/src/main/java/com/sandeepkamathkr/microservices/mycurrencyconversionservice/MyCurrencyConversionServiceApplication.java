package com.sandeepkamathkr.microservices.mycurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sandeepkamathkr.microservices.mycurrencyconversionservice")
public class MyCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCurrencyConversionServiceApplication.class, args);
	}

}
