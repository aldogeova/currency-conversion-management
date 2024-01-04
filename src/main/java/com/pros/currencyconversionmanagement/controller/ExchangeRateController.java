package com.pros.currencyconversionmanagement.controller;

import com.pros.currencyconversionbase.model.ExchangeRate;
import com.pros.currencyconversionmanagement.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This controller provides methods for managing exchange rates.
 */

@RestController
@RequestMapping("/api/exchangeRates")
public class ExchangeRateController {

    private final ExchangeRateService service;

    public ExchangeRateController(ExchangeRateService service) {
        this.service = service;
    }


    /**
     * Get an exchange rate by its ID.
     *
     * @param id The ID of the exchange rate.
     * @return A Mono containing the exchange rate.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get an exchange rate by its ID")
    public Mono<ExchangeRate> getRateById(@PathVariable String id) {
        return service.getRateById(id);
    }


    /**
     * Create a new exchange rate.
     *
     * @param rate The exchange rate to create.
     * @return A Mono containing the created exchange rate.
     */
    @PostMapping
    @Operation(summary = "Create a new exchange rate")
    public Mono<ExchangeRate> createRate(@Valid @RequestBody ExchangeRate rate) {
        return service.saveRate(rate);
    }

    /**
     * Update an existing exchange rate.
     *
     * @param id   The ID of the exchange rate to update.
     * @param rate The exchange rate to update.
     * @return A Mono containing the updated exchange rate.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing exchange rate")
    public Mono<ExchangeRate> updateRate(@PathVariable String id, @RequestBody ExchangeRate rate) {
        return service.getRateById(id)
                .flatMap(existingRate -> {
                        BeanUtils.copyProperties(rate, existingRate, "id");
                        return service.saveRate(existingRate);
                });
    }

    /**
     * Delete an exchange rate by its ID.
     *
     * @param id The ID of the exchange rate to delete.
     * @return A Mono containing a void value.
     */
    @DeleteMapping("/{id}")
    public Mono<Void> deleteRate(@PathVariable String id) {
        return service.deleteRate(id);
    }


}
