package com.hibernate.entity;

/**
 * TExpIndex entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExpIndex implements java.io.Serializable {

	// Fields

	private TExpIndexId id;
	private Integer guiyueDepth;
	private Integer weighDepth;

	// Constructors

	/** default constructor */
	public TExpIndex() {
	}

	/** full constructor */
	public TExpIndex(TExpIndexId id, Integer guiyueDepth, Integer weighDepth) {
		this.id = id;
		this.guiyueDepth = guiyueDepth;
		this.weighDepth = weighDepth;
	}

	// Property accessors

	public TExpIndexId getId() {
		return this.id;
	}

	public void setId(TExpIndexId id) {
		this.id = id;
	}

	public Integer getGuiyueDepth() {
		return this.guiyueDepth;
	}

	public void setGuiyueDepth(Integer guiyueDepth) {
		this.guiyueDepth = guiyueDepth;
	}

	public Integer getWeighDepth() {
		return this.weighDepth;
	}

	public void setWeighDepth(Integer weighDepth) {
		this.weighDepth = weighDepth;
	}

}