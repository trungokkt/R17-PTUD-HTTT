package com.restfulapi.restfulapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restfulapi.restfulapi.model.Product;
import com.restfulapi.restfulapi.model.ProductType;

public interface ProductTypeRepository extends  JpaRepository<ProductType,Integer>{
	@Query("SELECT pt FROM ProductType pt")
	List<ProductType> getProductTypeJoinProduct();
}