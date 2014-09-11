package com.hibernate.entity;

/**
 * TCompany entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCompany implements java.io.Serializable {

	// Fields

	private String stockId;
	private String stockShortName;
	private String companyName;
	private String area;
	private String classificationOfCsrc;
	private String classificationOfGics;
	private String comments;

	// Constructors

	/** default constructor */
	public TCompany() {
	}

	/** minimal constructor */
	public TCompany(String stockShortName, String companyName,
			String classificationOfCsrc, String classificationOfGics) {
		this.stockShortName = stockShortName;
		this.companyName = companyName;
		this.classificationOfCsrc = classificationOfCsrc;
		this.classificationOfGics = classificationOfGics;
	}

	/** full constructor */
	public TCompany(String stockShortName, String companyName, String area,
			String classificationOfCsrc, String classificationOfGics,
			String comments) {
		this.stockShortName = stockShortName;
		this.companyName = companyName;
		this.area = area;
		this.classificationOfCsrc = classificationOfCsrc;
		this.classificationOfGics = classificationOfGics;
		this.comments = comments;
	}

	// Property accessors

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockShortName() {
		return this.stockShortName;
	}

	public void setStockShortName(String stockShortName) {
		this.stockShortName = stockShortName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getClassificationOfCsrc() {
		return this.classificationOfCsrc;
	}

	public void setClassificationOfCsrc(String classificationOfCsrc) {
		this.classificationOfCsrc = classificationOfCsrc;
	}

	public String getClassificationOfGics() {
		return this.classificationOfGics;
	}

	public void setClassificationOfGics(String classificationOfGics) {
		this.classificationOfGics = classificationOfGics;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}