package com.org.vo;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	// 基本信息
	private int userId;
	private String name;
	private String username;
	private String birthdate;
	private String gender;
	private String bloodtype;
	private String phone;
	private String email;
	private String password;
	private String avatar;

	private Date registerDate;
	// 构造器
	public User() {
		// 默认构造器
	}
	// Getter 和 Setter 方法
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getAvatar(){
		return avatar;
	}
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegisterDate(Date date) {
		this.registerDate = date;
	}
	public Date getRegisterDate() {
		return registerDate;
	}

}
