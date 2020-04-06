package com.spring.boot.ui.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "category")
public class CategoryEntity extends TimeEntity{

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CategoryId;
	
	//default=0
	@Column(name = "id_parent",nullable=false)
	private Long idParent;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String icon;
	
	@Column(nullable=false)
	private String description;
	
	@Builder
	public CategoryEntity(Long idParent, String title, String icon, String description) {
		this.idParent = idParent;
		this.title = title;
		this.icon = icon;
		this.description = description;
	}
}

//CREATE TABLE `category` (
//		  `id` int(11) NOT NULL AUTO_INCREMENT,
//		  `id_parent` int(11) NOT NULL DEFAULT '0',
//		  `title` varchar(200) NOT NULL,
//		  `icon` varchar(200) NOT NULL,
//		  `description` varchar(2000) DEFAULT '',
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`id`)
//		)