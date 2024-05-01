package com.restService.countryDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryDetailsApplication {
	
	// Logger to send output to Console
	private static final Logger log = LoggerFactory.getLogger(CountryDetailsApplication.class);

	public static void main(String[] args) {
		String countryURI = "https://restcountries.com/v3.1/name/";
		SpringApplication.run(CountryDetailsApplication.class, args);
		log.info("GET operation against " + countryURI + ". Use countryName as query param, defaults to using USA.");
	}
}
