package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CUSTOM")
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String profile_pic;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_Pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profilePic) {
		this.profile_pic = profilePic;
	}
	
	
}
