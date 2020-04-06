package com.spring.boot.ui.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity{

	@Id
	@Column(name = "board_id", length=20, nullable=false)
	private String BoardId;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity id;
	
	@Lob
	@Column(name = "type")
	private String type;
	
	
	@Builder
	public BoardEntity(String BoardId, UsersEntity id, String type) {
		this.BoardId = BoardId;
		this.id = id;
		this.type = type;
		this.getCreatedDate();
		this.getModifiedDateTime();
	}
	
	
	
//	CREATE TABLE `board` (
//			  `id` varchar(20) NOT NULL,
//			  `username` varchar(50) NOT NULL,
//			  `type` varchar(20) NOT NULL,
//			  `content` blob NOT NULL,
//			  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//			  `update_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//			  PRIMARY KEY (`id`),
//			  KEY `board_FK` (`username`),
//			  CONSTRAINT `board_FK` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
//			)
}
