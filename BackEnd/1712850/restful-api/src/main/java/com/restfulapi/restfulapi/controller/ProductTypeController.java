package com.restfulapi.restfulapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapi.restfulapi.model.ProductType;
import com.restfulapi.restfulapi.repository.ProductTypeRepository;

@RestController
@RequestMapping("api/v1")
public class ProductTypeController {

	@Autowired
	private ProductTypeRepository ProductTypeRepository;
	
	@GetMapping("producttype")
	public List<ProductType> getAllProducts() {
		return ProductTypeRepository.getProductTypeJoinProduct();
//		Sort sortable = null;
//		if (sort.equals("ASC")) {
//			sortable = Sort.by(ColumSort).ascending();
//		}
//		if (sort.equals("DESC")) {
//		    sortable = Sort.by(ColumSort).descending();
//		}
//		Integer limit = 5;
//		
//		Pageable pageable = PageRequest.of(page, limit, sortable);
//		return ProductRepository.findAllMore(pageable);
	}
	
}
