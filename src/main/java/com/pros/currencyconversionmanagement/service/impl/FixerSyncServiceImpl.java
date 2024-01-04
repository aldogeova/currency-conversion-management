package com.pros.currencyconversionmanagement.service.impl;

import com.pros.currencyconversionbase.model.ExchangeRate;
import com.pros.currencyconversionmanagement.dto.FixerRateResponse;
import com.pros.currencyconversionmanagement.repository.ExchangeRateRepository;
import com.pros.currencyconversionmanagement.service.FixerSyncService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-31
 * This class is an implementation of the FixerSyncService interface.
 * It implements the updateExchangeRates method.
 *
 */
@Service
@RequiredArgsConstructor
public class FixerSyncServiceImpl implements FixerSyncService {

    private static final Logger logger = LoggerFactory.getLogger(FixerSyncServiceImpl.class);

    private WebClient webClient;
    private final ExchangeRateRepository exchangeRateRepository;

    @Value("${fixer.api.url}")
    private String baseUrl;

    @Value("${fixer.api.access-key}")
    private String accessKey;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    /**
     * This method updates the exchange rates in the database.
     * It uses the Fixer API to get the latest exchange rates.
     */
    @Override
    public void updateExchangeRates() {
        logger.info("Start updating exchange rates with Fixer API");
        webClient.get().uri("/latest?access_key={accessKey}", accessKey)
                .retrieve()
                .bodyToMono(FixerRateResponse.class)
                .flatMapMany(response -> {
                    String baseCurrency = response.getBase();
                    Instant baseTimestamp = response.getTimestamp();

                    return Flux.fromIterable(response.getRates().entrySet())
                            .map(entry -> new ExchangeRate(null, baseCurrency, entry.getKey(), BigDecimal.valueOf(entry.getValue()), baseTimestamp));
                })
                .flatMap(exchangeRateRepository::save)
                .count()
                .doOnSuccess(count -> logger.info("Completed updating " + count + " exchange rates with Fixer API"))
                .doOnError(error -> logger.error("Error updating exchange rates with Fixer API: "+ error.getMessage()))
                .doOnTerminate(() -> logger.info("Terminated updating exchange rates with Fixer API"))
                .subscribe();
    }

}
