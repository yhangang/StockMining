package com.hibernate.entity;

/**
 * TCompanyIndex entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCompanyIndex implements java.io.Serializable {

	// Fields

	private TCompanyIndexId id;
	private double indexValue;

	// Constructors

	/** default constructor */
	public TCompanyIndex() {
	}

	/** full constructor */
	public TCompanyIndex(TCompanyIndexId id, double indexValue) {
		this.id = id;
		this.indexValue = indexValue;
	}

	// Property accessors

	public TCompanyIndexId getId() {
		return this.id;
	}

	public void setId(TCompanyIndexId id) {
		this.id = id;
	}

	public double getIndexValue() {
		return this.indexValue;
	}

	public void setIndexValue(double indexValue) {
		this.indexValue = indexValue;
	}

}