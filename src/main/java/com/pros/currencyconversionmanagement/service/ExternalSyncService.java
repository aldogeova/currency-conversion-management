package com.pros.currencyconversionmanagement.service;

/**
 * @author aldonavarreteluna
 * @version 1.0.0
 * @since 2023-12-31
 * This interface is a contract for the external sync service.
 * It defines the method that must be implemented by the external sync service.
 *
 */
public interface ExternalSyncService {

    /**
     * This method is used to update the exchange rates.
     */
    public void updateExchangeRates();
}
