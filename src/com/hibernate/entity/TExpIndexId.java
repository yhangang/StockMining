package com.hibernate.entity;

/**
 * TExpIndexId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExpIndexId implements java.io.Serializable {

	// Fields

	private Integer expId;
	private String indexId;

	// Constructors

	/** default constructor */
	public TExpIndexId() {
	}

	/** full constructor */
	public TExpIndexId(Integer expId, String indexId) {
		this.expId = expId;
		this.indexId = indexId;
	}

	// Property accessors

	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TExpIndexId))
			return false;
		TExpIndexId castOther = (TExpIndexId) other;

		return ((this.getExpId() == castOther.getExpId()) || (this.getExpId() != null
				&& castOther.getExpId() != null && this.getExpId().equals(
				castOther.getExpId())))
				&& ((this.getIndexId() == castOther.getIndexId()) || (this
						.getIndexId() != null
						&& castOther.getIndexId() != null && this.getIndexId()
						.equals(castOther.getIndexId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getExpId() == null ? 0 : this.getExpId().hashCode());
		result = 37 * result
				+ (getIndexId() == null ? 0 : this.getIndexId().hashCode());
		return result;
	}

}