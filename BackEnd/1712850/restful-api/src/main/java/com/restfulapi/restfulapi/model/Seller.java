package com.restfulapi.restfulapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Seller")
public class Seller {
	@Id	
	@Column(name="Userid",nullable = false,columnDefinition = "int")
	private int UserId;
	
    //@OneToOne(mappedBy = "seller")
	//private UserInfo UserInfo;
}
