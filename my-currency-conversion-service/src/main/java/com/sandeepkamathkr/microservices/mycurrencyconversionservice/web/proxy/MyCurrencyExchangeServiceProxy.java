package com.sandeepkamathkr.microservices.mycurrencyconversionservice.web.proxy;

import com.sandeepkamathkr.microservices.mycurrencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "my-currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "my-currency-exchange-service")
@RibbonClient(name = "my-currency-exchange-service")
public interface MyCurrencyExchangeServiceProxy {

    @GetMapping("/my-currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable(value = "from") String from,
                                                              @PathVariable(value = "to") String to);
}
