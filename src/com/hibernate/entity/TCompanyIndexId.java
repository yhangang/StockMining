package com.hibernate.entity;

/**
 * TCompanyIndexId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCompanyIndexId implements java.io.Serializable {

	// Fields

	private String stockId;
	private String indexId;
	private String indexDate;

	// Constructors

	/** default constructor */
	public TCompanyIndexId() {
	}

	/** full constructor */
	public TCompanyIndexId(String stockId, String indexId, String indexDate) {
		this.stockId = stockId;
		this.indexId = indexId;
		this.indexDate = indexDate;
	}

	// Property accessors

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getIndexDate() {
		return this.indexDate;
	}

	public void setIndexDate(String indexDate) {
		this.indexDate = indexDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TCompanyIndexId))
			return false;
		TCompanyIndexId castOther = (TCompanyIndexId) other;

		return ((this.getStockId() == castOther.getStockId()) || (this
				.getStockId() != null
				&& castOther.getStockId() != null && this.getStockId().equals(
				castOther.getStockId())))
				&& ((this.getIndexId() == castOther.getIndexId()) || (this
						.getIndexId() != null
						&& castOther.getIndexId() != null && this.getIndexId()
						.equals(castOther.getIndexId())))
				&& ((this.getIndexDate() == castOther.getIndexDate()) || (this
						.getIndexDate() != null
						&& castOther.getIndexDate() != null && this
						.getIndexDate().equals(castOther.getIndexDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStockId() == null ? 0 : this.getStockId().hashCode());
		result = 37 * result
				+ (getIndexId() == null ? 0 : this.getIndexId().hashCode());
		result = 37 * result
				+ (getIndexDate() == null ? 0 : this.getIndexDate().hashCode());
		return result;
	}

}