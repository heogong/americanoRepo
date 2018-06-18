package com.issac.foundation.user.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_SEQ")
	private Long seq;
	
	@Column(name = "USER_ID")
	@NotEmpty(message = "*Please provide an ID")
	private String userId;
	
	@Column(name = "USER_PASSWD")
	//@Length(min = 5, message = "*Your password must have at least 5 characters")
	//@NotNull(message = "*Please provide your password")
	@Transient
	private String userPasswd;
	
	@Column(name = "USER_NM")
	@NotEmpty(message = "*Please provide your name")
	private String userNm;
	
	@Column(name = "USER_LV")
	private int userLv;
	
	@Column(name = "USER_AGE")
	private int userAge;
	
	@Column(name = "USER_TEL")
	private String userTel;
	
	@Column(name = "USER_ST")
	private int userSt;
	
	@Column(name = "USER_FL")
	private int userFl;
	
	@Column(name = "INST_DT")
	private Date instDt;
	
	@Column(name = "MOD_DT")
	private Date modDt;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TB_USER_ROLE", joinColumns = @JoinColumn(name = "USER_SEQ"), inverseJoinColumns = @JoinColumn(name = "ROLE_SEQ"))
	private Set<Role> roles;


	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
