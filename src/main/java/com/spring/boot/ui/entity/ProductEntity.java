package com.spring.boot.ui.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "product")
public class ProductEntity extends TimeEntity{
	
	@Id
	@Column(name = "product_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;
	
	
	@Column(name= "name", length = 500, nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private Long price;
	
	@Column(name="description", length=2000, nullable=false)
	private String description;
	
	@Column(name="image_url", length=200, nullable=false)
	private String imageUrl;
	
	@Column(length=200, nullable=false)
	private String color;
	
	@Column(name="size", length=200, nullable=false)
	private String size;
	
	@Column(name="discount", length=11, nullable=false)
	private Long discount;
	
	//카테고리와 조인.
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity CategoryId;
	
	@Builder
	public ProductEntity(Long ProductId, String name, Long price, String description, String imageUrl, String color, String size, Long discount, CategoryEntity CategoryId) {
		this.ProductId = ProductId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.color = color;
		this.size = size;
		this.discount = discount;
		this.CategoryId = CategoryId;
		
	}
	
}

//CREATE TABLE `product` (
//		  `id` int(11) NOT NULL AUTO_INCREMENT,
//		  `name` varchar(500) NOT NULL,
//		  `price` int(10) unsigned NOT NULL,
//		  `description` varchar(2000) NOT NULL,
//		  `image_url` varchar(200) NOT NULL,
//		  `color` varchar(200) NOT NULL,
//		  `size` varchar(200) NOT NULL,
//		  `discount` int(11) NOT NULL,
//		  `category_id` int(11) NOT NULL,
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`id`),
//		  KEY `product_FK` (`category_id`),
//		  CONSTRAINT `product_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
//		)
