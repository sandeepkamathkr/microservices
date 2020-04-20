package com.sandeepkamathkr.microservices.mycurrencyexchangeservice.repository;

import com.sandeepkamathkr.microservices.mycurrencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findAllByFromAndTo(String from, String to);
}
