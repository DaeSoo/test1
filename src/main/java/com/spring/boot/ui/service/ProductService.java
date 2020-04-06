package com.spring.boot.ui.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.ui.dto.ProductDto;
import com.spring.boot.ui.entity.ProductEntity;
import com.spring.boot.ui.repository.ProductRepository;

@Service
public class ProductService {

		@Autowired
		private ModelMapper modelMapper;
		
		@Autowired
		private ProductRepository productRepository;
		
		/**
		 * 메뉴 아이디로 상품목록 조회
		 * @param categoryId
		 * @return
		 */
		
		public List<ProductEntity> getProductList(Long categoryId){
			return productRepository.findAllByCategoryId(categoryId);
		}
		
		/**
		 * 상품 상세 조회
		 * @param categoryId
		 * @return
		 */
		public ProductDto getProduct(Long categoryId) {
			ProductDto productDto = modelMapper.map(productRepository.findById(categoryId).get(), ProductDto.class);
			productDto.setDiscountPrice(productDto.getPrice() * (100 - productDto.getDiscount())/100);
			return productDto;
		}
		
}
