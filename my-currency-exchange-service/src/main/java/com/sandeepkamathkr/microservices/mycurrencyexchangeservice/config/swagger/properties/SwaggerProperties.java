package com.sandeepkamathkr.microservices.mycurrencyexchangeservice.config.swagger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger properties for custom config
 */

@ConfigurationProperties(prefix = "my.currency.exchange.service.swagger",ignoreUnknownFields = false)
public class SwaggerProperties {

    private String defaultIncludePattern = "/.*";

    private String authorizationName = "jwt";

    public String getDefaultIncludePattern() {
        return defaultIncludePattern;
    }

    public void setDefaultIncludePattern(String defaultIncludePattern) {
        this.defaultIncludePattern = defaultIncludePattern;
    }

    public String getAuthorizationName() {
        return authorizationName;
    }

    public void setAuthorizationName(String authorizationName) {
        this.authorizationName = authorizationName;
    }
}
