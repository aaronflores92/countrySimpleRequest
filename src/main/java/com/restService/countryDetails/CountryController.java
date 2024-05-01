package com.restService.countryDetails;

// Standard Data Types
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Logging Packages
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// JSON Processing
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

// Jackson Annotations
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Request Processing
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.core.ParameterizedTypeReference;

@RestController
public class CountryController {   

	// Logger to send output to Console
	private static final Logger log = LoggerFactory.getLogger(CountryDetailsApplication.class);

	// RestTemplate for JSON processing
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @GetMapping("/countryDetails")
    public ResponseEntity<List<Country>>  countryDetails(@RequestParam(value = "countryName", defaultValue = "United States") String countryName, RestTemplate restTemplate) throws Exception {
        String countryURI = "https://restcountries.com/v3.1/name/";
        HttpStatus respStatus = HttpStatus.OK;
		List<Country> returnedCountries = null;

		// https://stackoverflow.com/a/31947188/21808087
		log.info("Executing GET operation against " + countryURI + countryName + ".");
		ResponseEntity<List<Country>> countryResponse =
			// Execute GET against countryURI, response returned as ResponseEntity
			restTemplate.exchange(countryURI + countryName, HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {});
            
		// Extract response body
        returnedCountries = countryResponse.getBody();
		log.info("GET operation against " + countryURI + countryName + " completed with OK response status.");
        return new ResponseEntity<List<Country>>(returnedCountries, respStatus);
    }
}