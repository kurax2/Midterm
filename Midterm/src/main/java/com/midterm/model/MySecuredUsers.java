package com.midterm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class MySecuredUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Size(min=5, message="invalid username")
	private String username; // cannot be null , cannot be less than 5 characters
	@NotNull
	@Size(min=5, message="invalid password")
	private String password; // cannot be null , cannot be less than 5 characters
	@NotNull
	@Min(value=18, message="too young")
	private int age; // cannot be less than 18
	@NotNull
	//@Size(max=8, message="invalid pin")
	private long pincode; // should be valid pincode , which includes all numeric values and max 8 digits
	private String role;
	
	public MySecuredUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MySecuredUsers(String username, String password, int age, long pincode, String role) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.pincode = pincode;
		this.role = role;
	}
	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "MySecuredUsers [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", pincode=" + pincode + ", role=" + role + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

	
}
