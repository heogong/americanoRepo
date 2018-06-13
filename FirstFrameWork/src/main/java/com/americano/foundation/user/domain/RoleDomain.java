package com.americano.foundation.user.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROLES")
public class RoleDomain {
	 @Id
	 @GeneratedValue
	 @Column(name="ROLES_PK", nullable=true)
	 private Integer id;
	 
	 @Column(name="ROLE", nullable=true)
	 private String role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="TB_USER_ROLES",
		joinColumns = {@JoinColumn(name="ROLES_PK", referencedColumnName="ROLES_PK")},
		inverseJoinColumns = {@JoinColumn(name="USER_PK", referencedColumnName="USER_PK")}
    )
	private Set<UserDomain> userRoles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserDomain> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserDomain> userRoles) {
		this.userRoles = userRoles;
	}
}
