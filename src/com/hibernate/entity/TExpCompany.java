package com.hibernate.entity;

/**
 * TExpCompany entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExpCompany implements java.io.Serializable {

	// Fields

	private TExpCompanyId id;
	private Integer category;

	// Constructors

	/** default constructor */
	public TExpCompany() {
	}

	/** minimal constructor */
	public TExpCompany(TExpCompanyId id) {
		this.id = id;
	}

	/** full constructor */
	public TExpCompany(TExpCompanyId id, Integer category) {
		this.id = id;
		this.category = category;
	}

	// Property accessors

	public TExpCompanyId getId() {
		return this.id;
	}

	public void setId(TExpCompanyId id) {
		this.id = id;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

}