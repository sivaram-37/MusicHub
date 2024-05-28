package com.musichub.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	private String gender;
	private String role;
	private String phone;
	private String dob;
	private String address;
	private boolean premium;
	
	public User() {
		super();
	}
	public User(int userid, String username, String email, String password, String gender, String role, String phone,
			String dob, String address,boolean premium) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
		this.premium=premium;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public boolean getPremium() {
		return premium;
	}
	public int getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getRole() {
		return role;
	}
	public String getPhone() {
		return phone;
	}
	public String getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", phone=" + phone + ", dob=" + dob + ", address=" + address
				+ ", premium=" + premium + "]";
	}
	
	
}




