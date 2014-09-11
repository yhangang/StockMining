package com.hibernate.entity;

/**
 * TIndex entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TIndex implements java.io.Serializable {

	// Fields

	private String indexId;
	private String indexName;
	private String indexType;

	// Constructors

	/** default constructor */
	public TIndex() {
	}

	/** minimal constructor */
	public TIndex(String indexName) {
		this.indexName = indexName;
	}

	/** full constructor */
	public TIndex(String indexName, String indexType) {
		this.indexName = indexName;
		this.indexType = indexType;
	}

	// Property accessors

	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getIndexName() {
		return this.indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexType() {
		return this.indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

}