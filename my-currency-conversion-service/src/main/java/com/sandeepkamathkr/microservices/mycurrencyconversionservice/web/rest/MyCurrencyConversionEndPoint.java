package com.sandeepkamathkr.microservices.mycurrencyconversionservice.web.rest;

import com.sandeepkamathkr.microservices.mycurrencyconversionservice.bean.CurrencyConversion;
import com.sandeepkamathkr.microservices.mycurrencyconversionservice.web.proxy.MyCurrencyExchangeServiceProxy;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MyCurrencyConversionEndPoint {

    private final MyCurrencyExchangeServiceProxy myCurrencyExchangeServiceProxy;

    @ApiOperation(value = "Converts currency", response = CurrencyConversion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})

    @GetMapping("/my-currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(
            @ApiParam(value = "from", required = true) @PathVariable(value = "from") String from,
            @ApiParam(value = "to", required = true) @PathVariable(value = "to") String to,
            @ApiParam(value = "quantity", required = true) @PathVariable(value = "quantity") BigDecimal quantity) {

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/my-currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return CurrencyConversion.builder()
                .id(1L)
                .from(from)
                .to(to)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .quantity(quantity)
                .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                .port(currencyConversion.getPort())
                .build();
    }

    @GetMapping("/my-currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversionFeign(
            @ApiParam(value = "from", required = true) @PathVariable(value = "from") String from,
            @ApiParam(value = "to", required = true) @PathVariable(value = "to") String to,
            @ApiParam(value = "quantity", required = true) @PathVariable(value = "quantity") BigDecimal quantity) {


        CurrencyConversion currencyConversion = myCurrencyExchangeServiceProxy. retrieveExchangeValue(from,to);
        return CurrencyConversion.builder()
                .id(1L)
                .from(from)
                .to(to)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .quantity(quantity)
                .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                .port(currencyConversion.getPort())
                .build();
    }
}
