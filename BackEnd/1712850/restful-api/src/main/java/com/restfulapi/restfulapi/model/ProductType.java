package com.restfulapi.restfulapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producttype")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Producttypeid",nullable = false,columnDefinition = "int")
	private int productTypeId;
	
	@Column(name="Producttypename",nullable = true,columnDefinition = "nvarchar(50)")
	private String productTypeName;

	// key
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ProductType")
	private Set<Product> listProduct = new HashSet<Product>();
	
	// get set
	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
}
