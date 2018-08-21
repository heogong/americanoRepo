package com.issac.foundation.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROLE")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ROLE_SEQ")
	private int roleSeq;

	@Column(name="ROLE")
	private String role;

	public int getRoleSeq() {
		return roleSeq;
	}
	public void setRoleSeq(int roleSeq) {
		this.roleSeq = roleSeq;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
