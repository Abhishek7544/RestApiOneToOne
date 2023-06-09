package com.jocata.vo;


public class EmpCountryVo {
	private String ename;
	private String estatus;
	
	private Country_vo country_vo;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Country_vo getCountry_vo() {
		return country_vo;
	}

	public void setCountry_vo(Country_vo country_vo) {
		this.country_vo = country_vo;
	}

	@Override
	public String toString() {
		return "EmpCountryVo [ename=" + ename + ", estatus=" + estatus + ", country_vo=" + country_vo + "]";
	}

	public EmpCountryVo(String ename, String estatus, Country_vo country_vo) {
		super();
		this.ename = ename;
		this.estatus = estatus;
		this.country_vo = country_vo;
	}

	public EmpCountryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
