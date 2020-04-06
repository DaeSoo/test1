package com.spring.boot.ui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.ui.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductRepository, Long>{

	
	/*
	 * @param categoryId 
	 * @return
	 */
	List<ProductEntity> findAllByCategoryId(Long catrgoryId);
}
