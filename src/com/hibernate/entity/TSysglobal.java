package com.hibernate.entity;

/**
 * TSysglobal entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysglobal implements java.io.Serializable {

	// Fields

	private TSysglobalId id;

	// Constructors

	/** default constructor */
	public TSysglobal() {
	}

	/** full constructor */
	public TSysglobal(TSysglobalId id) {
		this.id = id;
	}

	// Property accessors

	public TSysglobalId getId() {
		return this.id;
	}

	public void setId(TSysglobalId id) {
		this.id = id;
	}

}