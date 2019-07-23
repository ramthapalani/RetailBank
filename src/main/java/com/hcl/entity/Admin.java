package com.hcl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long userId;
private String password;
public Admin() {
	
}
public long getUserId() {
	return userId;
}
public String getPassword() {
	return password;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public void setPassword(String password) {
	this.password = password;
}
public Admin(long userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
}
}
