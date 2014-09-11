package com.hibernate.entity;

/**
 * TStCompany entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TStCompany implements java.io.Serializable {

	// Fields

	private TStCompanyId id;

	// Constructors

	/** default constructor */
	public TStCompany() {
	}

	/** full constructor */
	public TStCompany(TStCompanyId id) {
		this.id = id;
	}

	// Property accessors

	public TStCompanyId getId() {
		return this.id;
	}

	public void setId(TStCompanyId id) {
		this.id = id;
	}

}