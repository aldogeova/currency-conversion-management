package com.pros.currencyconversionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pros.currencyconversionmanagement", "com.pros.currencyconversionbase"} )
public class CurrencyConversionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionManagementApplication.class, args);
    }

}
