package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // HO1 - Get all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // HO6 - Find by code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found: " + countryCode);
        }
        return result.get();
    }

    // HO7 - Add country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // HO8 - Update country
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found: " + code);
        }
        Country country = result.get();
        country.setName(name);
        countryRepository.save(country);
    }

    // HO9 - Delete country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // HO5 - Find by partial name
    @Transactional
    public List<Country> findCountriesByName(String partialName) {
        return countryRepository.findByNameContaining(partialName);
    }
}