package com.americano.foundation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class CustomerDomain {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid", nullable=false)
    private int userid;

	@Column(name="age", nullable=true)
	private int age;
	
	@Column(name="name", nullable=true)
	private String name;
	
	@Column(name="phone", nullable=true)
	private String phone;
	
	@Column(name="address", nullable=true)
	private String address;
	
	@Column(name="productInfo", nullable=true)
	private String productInfo;
	
	@Column(name="isvisb", nullable=true)
	private boolean isvisb;

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public boolean isIsvisb() {
		return isvisb;
	}

	public void setIsvisb(boolean isvisb) {
		this.isvisb = isvisb;
	}
}
