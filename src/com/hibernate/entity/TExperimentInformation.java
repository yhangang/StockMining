package com.hibernate.entity;

import java.util.Date;

/**
 * TExperimentInformation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TExperimentInformation implements java.io.Serializable {

	// Fields

	private Integer expId;
	private Integer userId;
	private String expName;
	private Date createTime;
	private Date updateTime;
	private String power;

	// Constructors

	/** default constructor */
	public TExperimentInformation() {
	}

	/** full constructor */
	public TExperimentInformation(Integer userId, String expName,
			Date createTime, Date updateTime, String power) {
		this.userId = userId;
		this.expName = expName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.power = power;
	}

	// Property accessors

	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpName() {
		return this.expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}