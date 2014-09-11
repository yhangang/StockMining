package com.hibernate.entity;

/**
 * TStCompanyId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TStCompanyId implements java.io.Serializable {

	// Fields

	private String year;
	private String stockId;

	// Constructors

	/** default constructor */
	public TStCompanyId() {
	}

	/** full constructor */
	public TStCompanyId(String year, String stockId) {
		this.year = year;
		this.stockId = stockId;
	}

	// Property accessors

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TStCompanyId))
			return false;
		TStCompanyId castOther = (TStCompanyId) other;

		return ((this.getYear() == castOther.getYear()) || (this.getYear() != null
				&& castOther.getYear() != null && this.getYear().equals(
				castOther.getYear())))
				&& ((this.getStockId() == castOther.getStockId()) || (this
						.getStockId() != null
						&& castOther.getStockId() != null && this.getStockId()
						.equals(castOther.getStockId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getStockId() == null ? 0 : this.getStockId().hashCode());
		return result;
	}

}