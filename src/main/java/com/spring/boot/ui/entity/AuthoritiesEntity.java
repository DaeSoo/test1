package com.spring.boot.ui.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "authorities")
public class AuthoritiesEntity extends TimeEntity implements Serializable{
	
	
	@Id
	@ManyToOne
	@JoinColumn(name ="user_id")
	private UsersEntity id;
		

	@Column(name = "authority", length = 50, nullable=false)
	private String authority;
	
	
	@Builder
	public AuthoritiesEntity(UsersEntity id, String authority) {
		this.id = id;
		this.authority = authority;
		this.getCreatedDate();
		this.getModifiedDateTime();
	}
}

//CREATE TABLE `authorities` (
//		  `username` varchar(50) NOT NULL,
//		  `authority` varchar(50) NOT NULL,
//		  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//		  PRIMARY KEY (`username`,`authority`),
//		  CONSTRAINT `authorities_FK` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
//		)