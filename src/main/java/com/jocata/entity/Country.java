package com.jocata.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_post1")
	@SequenceGenerator(name = "seq_post1",initialValue = 2000,allocationSize = 5)
	@Column(name = "COUNTRY_ID")
	private int countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "COUNTRY_LANG")
	private String countryLang;

	@Column(name = "COUNTRY_POPULATION")
	private int countryPopulation;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryLang() {
		return countryLang;
	}

	public void setCountryLang(String countryLang) {
		this.countryLang = countryLang;
	}

	public int getCountryPopulation() {
		return countryPopulation;
	}

	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryLang=" + countryLang
				+ ", countryPopulation=" + countryPopulation + "]";
	}

	public Country(int countryId, String countryName, String countryLang, int countryPopulation) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryLang = countryLang;
		this.countryPopulation = countryPopulation;
	}

	public Country() {
		super();
	}
	
}
