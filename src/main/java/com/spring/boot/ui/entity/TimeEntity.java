package com.spring.boot.ui.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	
	@LastModifiedDate
	private LocalDateTime modifiedDateTime;
	
	

}
