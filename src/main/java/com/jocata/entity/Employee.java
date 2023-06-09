package com.jocata.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MAPP_EMP")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_post")
	@SequenceGenerator(name = "seq_post",initialValue = 1000,allocationSize = 1)
	
	private int eid;
	@Column(name="EMP_NAME")
	private String ename;
	@Column(name="EMP_STATUS")
	private String estatus;
	@OneToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Employee(int eid, String ename, String estatus, Country country) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.estatus = estatus;
		this.country = country;
	}
	public Employee() {
		super();
	}
}
