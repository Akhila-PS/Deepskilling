package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        LOGGER.info("Inside main");

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindCountriesByName();
    }

    // HO1
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    // HO6
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }

    // HO7
    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Test Country");
        countryService.addCountry(country);
        Country fetched = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added country:{}", fetched);
        LOGGER.info("End");
    }

    // HO8
    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.updateCountry("ZZ", "Updated Test Country");
        Country updated = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated country:{}", updated);
        LOGGER.info("End");
    }

    // HO9
    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.debug("Deleted country with code ZZ");
        LOGGER.info("End");
    }

    // HO5
    private static void testFindCountriesByName() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesByName("land");
        LOGGER.debug("Countries matching 'land':{}", countries);
        LOGGER.info("End");
    }
}