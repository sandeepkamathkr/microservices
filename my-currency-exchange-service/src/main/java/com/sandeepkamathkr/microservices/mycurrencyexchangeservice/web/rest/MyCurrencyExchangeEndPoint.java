package com.sandeepkamathkr.microservices.mycurrencyexchangeservice.web.rest;

import com.sandeepkamathkr.microservices.mycurrencyexchangeservice.bean.ExchangeValue;
import com.sandeepkamathkr.microservices.mycurrencyexchangeservice.repository.ExchangeValueRepository;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Api("/my-currency-exchange")
@RestController
@RequestMapping("/my-currency-exchange")
@AllArgsConstructor
public class MyCurrencyExchangeEndPoint {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;

    @ApiOperation(value = "retrieve Exchange Value", response = ExchangeValue.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@ApiParam(value = "from", required = true) @PathVariable(value = "from") String from,
                                                         @ApiParam(value = "to", required = true) @PathVariable(value = "to") String to) {

        Optional<ExchangeValue> exchangeValue = exchangeValueRepository.findAllByFromAndTo(from, to);
        if (exchangeValue.isPresent()) {
            exchangeValue.get().setPort(
                    Integer.parseInt(environment.getProperty("local.server.port")));
            return exchangeValue.get();
        } else {
            return ExchangeValue.builder().build();
        }
    }
}
