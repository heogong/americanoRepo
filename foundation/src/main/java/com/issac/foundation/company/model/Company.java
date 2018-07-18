package com.issac.foundation.company.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.issac.foundation.user.model.User;

@Entity
@Table(name = "TB_COMP")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMP_SEQ")
	private Long compSeq;
	
	@Column(name = "COMP_NM")
	private String compNm;
	
	@Column(name = "COMP_OWNER")
	private String compOwner;
	
	@Column(name = "COMP_TEL")
	private String compTel;
	
	@Column(name = "COMP_FL")
	private int compFl;
	
	@Column(name = "INST_DT")
	private Date instDt;
	
	@Column(name = "MOD_DT")
	private Date modDt;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="COMP_SEQ")
	private Set<User> users;
	
	public Long getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(Long compSeq) {
		this.compSeq = compSeq;
	}

	public String getCompNm() {
		return compNm;
	}

	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	public String getCompOwner() {
		return compOwner;
	}

	public void setCompOwner(String compOwner) {
		this.compOwner = compOwner;
	}

	public String getCompTel() {
		return compTel;
	}

	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}

	public int getCompFl() {
		return compFl;
	}

	public void setCompFl(int compFl) {
		this.compFl = compFl;
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
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
