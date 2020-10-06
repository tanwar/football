package com.sap.tanwar.football.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_id", "country_name", "country_logo" })
public class Country {

	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("country_logo")
	private String countryLogo;

	@JsonProperty("country_id")
	public String getCountryId() {
		return countryId;
	}

	@JsonProperty("country_id")
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@JsonProperty("country_name")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("country_name")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@JsonProperty("country_logo")
	public String getCountryLogo() {
		return countryLogo;
	}

	@JsonProperty("country_logo")
	public void setCountryLogo(String countryLogo) {
		this.countryLogo = countryLogo;
	}
}