package com.hibernate.entity;

import java.util.Date;

/**
 * TLoginLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TLoginLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String realname;
	private Date loginTime;
	private String loginIp;
	private String loginHost;

	// Constructors

	/** default constructor */
	public TLoginLog() {
	}

	/** full constructor */
	public TLoginLog(String username, String realname, Date loginTime,
			String loginIp, String loginHost) {
		this.username = username;
		this.realname = realname;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.loginHost = loginHost;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginHost() {
		return this.loginHost;
	}

	public void setLoginHost(String loginHost) {
		this.loginHost = loginHost;
	}

}