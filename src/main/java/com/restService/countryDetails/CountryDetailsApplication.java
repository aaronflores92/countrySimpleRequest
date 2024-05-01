package com.restService.countryDetails;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

@SpringBootApplication
public class CountryDetailsApplication {

	// Logger to send output to Console
	private static final Logger log = LoggerFactory.getLogger(CountryDetailsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CountryDetailsApplication.class, args);
	}

	// RestTemplate for JSON processing
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String countryURI = "https://restcountries.com/v3.1/name/united states";
			log.info("Running GET HTTP method against " + countryURI);
			// https://stackoverflow.com/a/31947188/21808087
			ResponseEntity<List<Country>> countryResponse =
			    // Execute GET against countryURI, response returned as ResponseEntity
			    restTemplate.exchange(countryURI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {});
			// Extract response body
			List<Country> returnedCountries = countryResponse.getBody();
			// Print details of returned countries
			for (Country countryDet : returnedCountries) {
				String countryIsIndependent = countryDet.getIsIndependent();
				int countryArea = countryDet.getTotalArea();
				int countryPop = countryDet.getTotalPopulation();
				log.info("Is Independent Country?: " + countryIsIndependent);
				log.info("Total Country Area: " + countryArea);
				log.info("Total Country Population: " + countryPop);
			}
			
		};
	}

}
