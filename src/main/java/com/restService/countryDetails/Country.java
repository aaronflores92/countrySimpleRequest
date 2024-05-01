package com.restService.countryDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    // Private Class Properties
    private String isIndependent;
    private int totalArea;
    private int totalPopulation;

    // Constructors
    public Country(@JsonProperty("independent") String isIndependentVal, @JsonProperty("area") int totalAreaVal, @JsonProperty("population")  int totalPopulationVal) {
        this.isIndependent = isIndependentVal;
        this.totalArea = totalAreaVal;
        this.totalPopulation = totalPopulationVal;
    }
    
    // Class Getters
    public String getIsIndependent() {
        return isIndependent;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }
}
