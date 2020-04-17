package com.sandeepkamathkr.microservices.mylimitsservice.web.rest;

import com.sandeepkamathkr.microservices.mylimitsservice.bean.LimitConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("limits")
@RestController
@RequestMapping("/limits")
public class LimitsConfigurationEndPoint {

    @ApiOperation(value = "retrieve Limits from Configuration",response = LimitConfiguration.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})
    @GetMapping
    public LimitConfiguration retrieveLimitsFromConfiguration(){
        return LimitConfiguration.builder()
                .maximum(1000)
                .minimum(1)
                .build();
    }
}
