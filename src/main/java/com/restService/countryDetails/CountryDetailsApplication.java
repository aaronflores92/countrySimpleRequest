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

	public static void main(String[] args) {
		SpringApplication.run(CountryDetailsApplication.class, args);
	}
}
