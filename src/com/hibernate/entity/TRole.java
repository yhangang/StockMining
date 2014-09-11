package com.hibernate.entity;

/**
 * TRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String note;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public TRole(String roleName, String note) {
		this.roleName = roleName;
		this.note = note;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}