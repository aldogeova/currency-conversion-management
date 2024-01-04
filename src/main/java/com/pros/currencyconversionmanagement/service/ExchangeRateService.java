package com.pros.currencyconversionmanagement.service;

import com.pros.currencyconversionbase.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This service provides methods for managing exchange rates.
 */
public interface ExchangeRateService {

    /**
     * Get an exchange rate by its ID.
     *
     * @param id The ID of the exchange rate.
     * @return A Mono containing the exchange rate.
     */
    Mono<ExchangeRate> getRateById(String id);

    /**
     * Save an exchange rate.
     *
     * @param rate The exchange rate to save.
     * @return A Mono containing the saved exchange rate.
     */
    Mono<ExchangeRate> saveRate(ExchangeRate rate);


    /**
     * Delete an exchange rate by its ID.
     *
     * @param id The ID of the exchange rate to delete.
     * @return A Mono containing a void value.
     */
    Mono<Void> deleteRate(String id);


}
