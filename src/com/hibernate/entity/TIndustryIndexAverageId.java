package com.hibernate.entity;

/**
 * TIndustryIndexAverageId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TIndustryIndexAverageId implements java.io.Serializable {

	// Fields

	private String industryId;
	private String indexId;
	private String indexDate;

	// Constructors

	/** default constructor */
	public TIndustryIndexAverageId() {
	}

	/** full constructor */
	public TIndustryIndexAverageId(String industryId, String indexId,
			String indexDate) {
		this.industryId = industryId;
		this.indexId = indexId;
		this.indexDate = indexDate;
	}

	// Property accessors

	public String getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
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
		if (!(other instanceof TIndustryIndexAverageId))
			return false;
		TIndustryIndexAverageId castOther = (TIndustryIndexAverageId) other;

		return ((this.getIndustryId() == castOther.getIndustryId()) || (this
				.getIndustryId() != null
				&& castOther.getIndustryId() != null && this.getIndustryId()
				.equals(castOther.getIndustryId())))
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

		result = 37
				* result
				+ (getIndustryId() == null ? 0 : this.getIndustryId()
						.hashCode());
		result = 37 * result
				+ (getIndexId() == null ? 0 : this.getIndexId().hashCode());
		result = 37 * result
				+ (getIndexDate() == null ? 0 : this.getIndexDate().hashCode());
		return result;
	}

}