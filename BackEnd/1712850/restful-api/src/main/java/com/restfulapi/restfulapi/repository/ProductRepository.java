package com.restfulapi.restfulapi.repository;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfulapi.restfulapi.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
    @Query(value="SELECT p FROM Product p")
    public List<Product> findAllMore(Pageable pageable);
    
    @Query(value="SELECT p FROM ProductType pt join pt.listProduct p where pt.productTypeId=2")
    public List<Product> findProductByProductType();

    
}