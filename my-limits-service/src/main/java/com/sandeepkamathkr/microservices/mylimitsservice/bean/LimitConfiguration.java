package com.sandeepkamathkr.microservices.mylimitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LimitConfiguration {
    private int maximum;
    private int minimum;
}
