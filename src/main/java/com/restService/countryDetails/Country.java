package com.restService.countryDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknow = true)
public class Country {

    // Private Class Properties
    private String isIndependent;
    private int totalArea;
    private int totalPopulation;

    // Constructors
    public Country(@JsonProperty("independent") String isIndependentVal, @JsonProperty("area") int totalAreaVal, @JsonProperty("population")  int totalPopulationVal) {
        this.isIndependent = isIndependentVal;
        this.totalArea = totalAreaVal;
        this.totalPopulationVal = totalPopulationVal;
    }
    
    // Class Setters
    public void setIsIndependent(String isIndependentVal) {
        this.isIndependent = isIndependentVal;
    }

    public void setTotalArea (int totalAreaVal) {
        this.totalArea = totalAreaVal;
    }

    public void setTotalPopulation (int totalPopulationVal) {
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