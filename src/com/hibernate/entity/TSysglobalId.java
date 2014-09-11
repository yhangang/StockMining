package com.hibernate.entity;

/**
 * TSysglobalId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSysglobalId implements java.io.Serializable {

	// Fields

	private String paramName;
	private String paramDesc;
	private String paramKey;
	private String paramVal;

	// Constructors

	/** default constructor */
	public TSysglobalId() {
	}

	/** full constructor */
	public TSysglobalId(String paramName, String paramDesc, String paramKey,
			String paramVal) {
		this.paramName = paramName;
		this.paramDesc = paramDesc;
		this.paramKey = paramKey;
		this.paramVal = paramVal;
	}

	// Property accessors

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamDesc() {
		return this.paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public String getParamKey() {
		return this.paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamVal() {
		return this.paramVal;
	}

	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TSysglobalId))
			return false;
		TSysglobalId castOther = (TSysglobalId) other;

		return ((this.getParamName() == castOther.getParamName()) || (this
				.getParamName() != null
				&& castOther.getParamName() != null && this.getParamName()
				.equals(castOther.getParamName())))
				&& ((this.getParamDesc() == castOther.getParamDesc()) || (this
						.getParamDesc() != null
						&& castOther.getParamDesc() != null && this
						.getParamDesc().equals(castOther.getParamDesc())))
				&& ((this.getParamKey() == castOther.getParamKey()) || (this
						.getParamKey() != null
						&& castOther.getParamKey() != null && this
						.getParamKey().equals(castOther.getParamKey())))
				&& ((this.getParamVal() == castOther.getParamVal()) || (this
						.getParamVal() != null
						&& castOther.getParamVal() != null && this
						.getParamVal().equals(castOther.getParamVal())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getParamName() == null ? 0 : this.getParamName().hashCode());
		result = 37 * result
				+ (getParamDesc() == null ? 0 : this.getParamDesc().hashCode());
		result = 37 * result
				+ (getParamKey() == null ? 0 : this.getParamKey().hashCode());
		result = 37 * result
				+ (getParamVal() == null ? 0 : this.getParamVal().hashCode());
		return result;
	}

}