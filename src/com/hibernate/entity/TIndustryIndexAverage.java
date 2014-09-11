package com.hibernate.entity;

/**
 * TIndustryIndexAverage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TIndustryIndexAverage implements java.io.Serializable {

	// Fields

	private TIndustryIndexAverageId id;
	private double indexValue;

	// Constructors

	/** default constructor */
	public TIndustryIndexAverage() {
	}

	/** minimal constructor */
	public TIndustryIndexAverage(TIndustryIndexAverageId id) {
		this.id = id;
	}

	/** full constructor */
	public TIndustryIndexAverage(TIndustryIndexAverageId id, double indexValue) {
		this.id = id;
		this.indexValue = indexValue;
	}

	// Property accessors

	public TIndustryIndexAverageId getId() {
		return this.id;
	}

	public void setId(TIndustryIndexAverageId id) {
		this.id = id;
	}

	public double getIndexValue() {
		return this.indexValue;
	}

	public void setIndexValue(double indexValue) {
		this.indexValue = indexValue;
	}

}