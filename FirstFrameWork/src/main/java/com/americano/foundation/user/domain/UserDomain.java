package com.americano.foundation.user.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_PK", nullable=false)
    private int userPK;
	
	@Column(name="USER_ID", nullable=true)
	private String userId;
	
	@Column(name="USER_PASSWD", nullable=true)
	private String userPasswd;
	
	@Column(name="USER_NM", nullable=true)
	private String userNm;
	
	@Column(name="USER_LV", nullable=true)
	private int userLv;
	
	@Column(name="USER_AGE")
	private int userAge;
	
	@Column(name="USER_TEL")
	private String userTel;
	
	@Column(name="USER_ST", nullable=true)
	private int userSt;

	@Column(name="USER_FL", nullable=true)
	private int userFl;
	
	@Column(name="INST_DT", nullable=true)
	private Date instDt;
	
	@Column(name="MOD_DT")
	private Date modDt;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="TB_USER_ROLES", 
		joinColumns = {@JoinColumn(name="USER_PK", referencedColumnName="USER_PK")}, 
		inverseJoinColumns = {@JoinColumn(name="ROLES_PK", referencedColumnName="ROLES_PK")}
	)
	private RoleDomain role;
	

	public int getUserPK() {
		return userPK;
	}
	public void setUserPK(int userPK) {
		this.userPK = userPK;
	}

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}


	public int getUserLv() {
		return userLv;
	}
	public void setUserLv(int userLv) {
		this.userLv = userLv;
	}


	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}


	public int getUserSt() {
		return userSt;
	}
	public void setUserSt(int userSt) {
		this.userSt = userSt;
	}


	public int getUserFl() {
		return userFl;
	}
	public void setUserFl(int userFl) {
		this.userFl = userFl;
	}


	public Date getInstDt() {
		return instDt;
	}
	public void setInstDt(Date instDt) {
		this.instDt = instDt;
	}


	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	
	
	public RoleDomain getRole() {
		return role;
	}
	public void setRole(RoleDomain role) {
		this.role = role;
	}

	
	
}
