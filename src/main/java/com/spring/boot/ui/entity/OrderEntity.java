package com.spring.boot.ui.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="orders")
@Getter
public class OrderEntity extends TimeEntity{
	

	@Id
	@Column(name = "order_id")
	private String Order;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity ProductId;
	
	@Column(name = "type")
//	@Convert(converter = StatusTypeConverter.class)
	private StatusType type;
	
	@Builder
	public OrderEntity(String Order, UsersEntity id, ProductEntity ProductId, StatusType type) {
		this.Order = Order;
		this.id = id;
		this.ProductId = ProductId;
		this.type = type;
		this.getCreatedDate();
		this.getModifiedDateTime();
		
	}
	

}


//CREATE TABLE `order` (
//		  `id` varchar(20) NOT NULL,
//		  `username` varchar(50) NOT NULL,
//		  `product_id` int(11) NOT NULL,
//		  `status` enum('ready','delivery','complete') NOT NULL,
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`id`),
//		  KEY `order_FK` (`product_id`),
//		  KEY `order_FK_1` (`username`),
//		  CONSTRAINT `order_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
//		  CONSTRAINT `order_FK_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
//		)