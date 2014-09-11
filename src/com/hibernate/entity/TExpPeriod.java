package com.hibernate.entity;

/**
 * TExpPeriod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExpPeriod implements java.io.Serializable {

	// Fields

	private Integer expId;
	private String startYear;
	private String endYear;

	// Constructors

	/** default constructor */
	public TExpPeriod() {
	}

	/** full constructor */
	public TExpPeriod(String startYear, String endYear) {
		this.startYear = startYear;
		this.endYear = endYear;
	}

	// Property accessors

	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public String getStartYear() {
		return this.startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return this.endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

}