package com.hibernate.entity;

/**
 * TExpCompanyId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExpCompanyId implements java.io.Serializable {

	// Fields

	private Integer expId;
	private String stockId;

	// Constructors

	/** default constructor */
	public TExpCompanyId() {
	}

	/** full constructor */
	public TExpCompanyId(Integer expId, String stockId) {
		this.expId = expId;
		this.stockId = stockId;
	}

	// Property accessors

	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
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
		if (!(other instanceof TExpCompanyId))
			return false;
		TExpCompanyId castOther = (TExpCompanyId) other;

		return ((this.getExpId() == castOther.getExpId()) || (this.getExpId() != null
				&& castOther.getExpId() != null && this.getExpId().equals(
				castOther.getExpId())))
				&& ((this.getStockId() == castOther.getStockId()) || (this
						.getStockId() != null
						&& castOther.getStockId() != null && this.getStockId()
						.equals(castOther.getStockId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getExpId() == null ? 0 : this.getExpId().hashCode());
		result = 37 * result
				+ (getStockId() == null ? 0 : this.getStockId().hashCode());
		return result;
	}

}