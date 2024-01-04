package com.pros.currencyconversionmanagement.service.impl;

import com.pros.currencyconversionbase.model.ExchangeRate;
import com.pros.currencyconversionmanagement.repository.ExchangeRateRepository;
import com.pros.currencyconversionmanagement.service.ExchangeRateService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 * This service provides methods for managing exchange rates.
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository repository;

    public ExchangeRateServiceImpl(ExchangeRateRepository repository) {
        this.repository = repository;
    }


    @Override
    public Mono<ExchangeRate> getRateById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<ExchangeRate> saveRate(ExchangeRate rate) {
        return repository.save(rate);
    }

    @Override
    public Mono<Void> deleteRate(String id) {
        return repository.deleteById(id);
    }


}
