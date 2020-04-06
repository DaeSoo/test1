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


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class UsersEntity extends TimeEntity{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String username;

	
	@Column(length = 500, nullable = false)
	private String password;
	
	@Column(length = 10, nullable = false)
	private int enabled;
	
	//TimeEntity에 있는 cretae,modify가져와야댐.
	
	
	
	@Builder
	public UsersEntity(Long id, String username, String password , int enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.getCreatedDate();
		this.getModifiedDateTime();
		
	}
}
//CREATE TABLE `users` (
//		  `username` varchar(50) NOT NULL,
//		  `password` varchar(500) NOT NULL,
//		  `enabled` tinyint(4) NOT NULL,
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`username`)
//		)