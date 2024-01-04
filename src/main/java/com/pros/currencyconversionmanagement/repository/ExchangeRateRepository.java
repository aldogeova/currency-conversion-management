package com.pros.currencyconversionmanagement.repository;

import com.pros.currencyconversionbase.model.ExchangeRate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-30
 */
public interface ExchangeRateRepository extends ReactiveMongoRepository<ExchangeRate, String> {
}
