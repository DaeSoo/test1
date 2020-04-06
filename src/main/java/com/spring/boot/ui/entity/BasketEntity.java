package com.spring.boot.ui.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name="basket")
@Getter

public class BasketEntity extends TimeEntity implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity ProductId;
	
	@Column(length=10, nullable=false)
	private Long count;
	
	@Builder
	public BasketEntity(UsersEntity id, ProductEntity ProductId, Long count) {
		this.id = id;
		this.ProductId = ProductId;
		this.count = count;
		this.getCreatedDate();
		this.getModifiedDateTime();
	}
	
	
}



//CREATE TABLE `basket` (
//		  `username` varchar(50) NOT NULL,
//		  `product_id` int(11) NOT NULL,
//		  `count` int(10) unsigned NOT NULL,
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`username`),
//		  KEY `basket_FK_product_id` (`product_id`),
//		  CONSTRAINT `basket_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
//		  CONSTRAINT `basket_FK_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
//		)