package com.americano.foundation.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "T_USER")
public class UserDomain {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PK_USER", nullable=false)
    private int pkUser;

	@Column(name="name", nullable=true)
	private String name;
	
	@Column(name="tel", nullable=true)
	private String tel;
	
	@Column(name="age", nullable=true)
	private int age;

	public int getPkUser() {
		return pkUser;
	}

	public void setPkUser(int pkUser) {
		this.pkUser = pkUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
