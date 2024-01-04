package com.pros.currencyconversionmanagement.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Map;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-31
 * This class is a data transfer object for the fixer rate response.
 */
@Data
public class FixerRateResponse {
    private String base;
    private String date;
    private Instant timestamp;
    private Map<String, Double> rates;
}
