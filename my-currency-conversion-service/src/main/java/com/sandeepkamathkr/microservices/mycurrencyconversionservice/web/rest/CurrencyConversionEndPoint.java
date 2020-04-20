package com.sandeepkamathkr.microservices.mycurrencyconversionservice.web.rest;

import com.sandeepkamathkr.microservices.mycurrencyconversionservice.bean.CurrencyConversion;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api("/currency-converter")
@RestController
@RequestMapping("/currency-converter")
@AllArgsConstructor
public class CurrencyConversionEndPoint {


    @ApiOperation(value = "Converts currency", response = CurrencyConversion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveLimitsFromConfiguration(
            @ApiParam(value = "from", required = true) @PathVariable(value = "from") String from,
            @ApiParam(value = "to", required = true) @PathVariable(value = "to") String to,
            @ApiParam(value = "quantity", required = true) @PathVariable(value = "quantity") int quantity) {

        return CurrencyConversion.builder()
                .id(1L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(1))
                .quantity(BigDecimal.valueOf(quantity))
                .totalCalculatedAmount(BigDecimal.valueOf(quantity))
                .port(0)
                .build();
    }
}
