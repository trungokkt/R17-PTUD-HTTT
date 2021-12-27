package com.restfulapi.restfulapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid",nullable = false,columnDefinition = "int")
	private int userId;
	
	@Column(name="username",nullable = true,columnDefinition = "nvarchar(50)")
	private String userName;

	@Column(name="userbirth",nullable = true,columnDefinition = "date")
	private int userBirth;

	@Column(name="usergender",nullable = true,columnDefinition = "int")
	private String userGender;

	@Column(name="userphone",nullable = true,columnDefinition = "varchar(20)")
	private int userPhone;
	
	@Column(name="userEmail",nullable = true,columnDefinition = "varchar(50)")
	private String useremail;

	@Column(name="useraddress",nullable = true,columnDefinition = "nvarchar(50)")
	private int userAddress;
	
	@Column(name="userArea",nullable = true,columnDefinition = "int")
	private String userArea;

	@Column(name="storeid",nullable = true,columnDefinition = "int")
	private int storeId;

	@Column(name="userloginname",nullable = true,columnDefinition = "varchar(50)")
	private String userLoginName;

	@Column(name="userpassword",nullable = true,columnDefinition = "varchar(50)")
	private int userPassword;

	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "userid", referencedColumnName = "id")
	//private Seller seller;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(int userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(int userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public int getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}
	
}
