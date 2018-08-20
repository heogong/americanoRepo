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

	@Column(name="ROLE_LV")
	private int roleLv;

	public enum LevelType {
		SYSTEM(1), COMP(2), EDU(3), USER(4);

		public int LEVEL;

		private LevelType(int lvNum){
			this.LEVEL = lvNum;
		}
	}

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

	public int getRoleLv() {
		return roleLv;
	}
	public void setRoleLv(int roleLv) {
		this.roleLv = roleLv;
	}
}
