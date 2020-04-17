package com.sandeepkamathkr.microservices.mylimitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "my.limits.service")
public class MyLimitsServiceProperties {

    private int maximum;
    private int minimum;
}
