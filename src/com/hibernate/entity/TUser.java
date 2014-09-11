package com.hibernate.entity;

/**
 * TUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String pwd;
	private String realname;
	private String college;
	private String phoneNumber;
	private String email;
	private String roleId;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String username, String pwd, String realname, String college,
			String roleId) {
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.college = college;
		this.roleId = roleId;
	}

	/** full constructor */
	public TUser(String username, String pwd, String realname, String college,
			String phoneNumber, String email, String roleId) {
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.college = college;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.roleId = roleId;
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

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}