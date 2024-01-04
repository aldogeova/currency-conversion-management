package com.pros.currencyconversionmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-31
 * This class is a configuration class for the scheduler.
 * It creates a bean for the task scheduler.
 *
 */
@Configuration
public class SchedulerConfig {

    /**
     * This method creates a bean for the task scheduler.
     * @return a task scheduler
     */
    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

}
