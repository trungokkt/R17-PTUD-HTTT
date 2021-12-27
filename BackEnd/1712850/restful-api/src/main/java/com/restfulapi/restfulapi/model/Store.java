package com.restfulapi.restfulapi.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="Store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="storeid",nullable = false,columnDefinition = "int")
	private int StoreId;
	
	@Column(name="storename",nullable = true,columnDefinition = "nvarchar(50)")
	private String StoreName;

	@Column(name="storeaddress",nullable = true,columnDefinition = "nvarchar(50)")
	private String StoreAddress;

	@Column(name="storephone",nullable = true,columnDefinition = "nvarchar(50)")
	private String StorePhone;

	@Column(name="storerate",nullable = true,columnDefinition = "int")
	private String StoreRate;

	@Column(name="storearea",nullable = true,columnDefinition = "int")
	private String StoreArea;

	@Column(name="Userid",nullable = true,columnDefinition = "int")
	private String UserId;
	
	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getStorePhone() {
		return StorePhone;
	}

	public void setStorePhone(String storePhone) {
		StorePhone = storePhone;
	}

	public String getStoreArea() {
		return StoreArea;
	}

	public void setStoreArea(String storeArea) {
		StoreArea = storeArea;
	}

	public String getStoreRate() {
		return StoreRate;
	}

	public void setStoreRate(String storeRate) {
		StoreRate = storeRate;
	}

	public String getStoreAddress() {
		return StoreAddress;
	}

	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}


}
