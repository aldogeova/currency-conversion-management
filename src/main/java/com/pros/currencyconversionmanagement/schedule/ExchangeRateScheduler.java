package com.pros.currencyconversionmanagement.schedule;

import com.pros.currencyconversionmanagement.service.FixerSyncService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ExchangeRateScheduler {

    private final FixerSyncService fixerSyncService;
    private final TaskScheduler taskScheduler;


    @Value("${fixer.minutes-sync}")
    public int fixedRateTime;

    @PostConstruct
    public void scheduleTask() {
        taskScheduler.scheduleAtFixedRate(
                () -> fixerSyncService.updateExchangeRates(),
                TimeUnit.MINUTES.toMillis(fixedRateTime)
        );
    }

}
