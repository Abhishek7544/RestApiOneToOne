package com.jocata.vo;

public class Country_vo {
	private String countryLang;
	private String countryName;
	private int countryPopulation;
	public String getCountryLang() {
		return countryLang;
	}
	public void setCountryLang(String countryLang) {
		this.countryLang = countryLang;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	public Country_vo(String countryLang, String countryName, int countryPopulation) {
		super();
		this.countryLang = countryLang;
		this.countryName = countryName;
		this.countryPopulation = countryPopulation;
	}
	public Country_vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
