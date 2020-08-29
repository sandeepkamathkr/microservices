package com.sandeepkamathkr.microservices.mylimitsservice;

import com.sandeepkamathkr.microservices.mylimitsservice.config.MyLimitsServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties({MyLimitsServiceProperties.class})
@EnableDiscoveryClient
public class MyLimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLimitsServiceApplication.class, args);
	}

}
