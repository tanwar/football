package com.sap.tanwar.football.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_id", "country_name", "league_id", "league_name", "league_season", "league_logo",
		"country_logo" })
public class League {

	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("league_id")
	private String leagueId;
	@JsonProperty("league_name")
	private String leagueName;
	@JsonProperty("league_season")
	private String leagueSeason;
	@JsonProperty("league_logo")
	private String leagueLogo;
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

	@JsonProperty("league_id")
	public String getLeagueId() {
		return leagueId;
	}

	@JsonProperty("league_id")
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	@JsonProperty("league_name")
	public String getLeagueName() {
		return leagueName;
	}

	@JsonProperty("league_name")
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	@JsonProperty("league_season")
	public String getLeagueSeason() {
		return leagueSeason;
	}

	@JsonProperty("league_season")
	public void setLeagueSeason(String leagueSeason) {
		this.leagueSeason = leagueSeason;
	}

	@JsonProperty("league_logo")
	public String getLeagueLogo() {
		return leagueLogo;
	}

	@JsonProperty("league_logo")
	public void setLeagueLogo(String leagueLogo) {
		this.leagueLogo = leagueLogo;
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
