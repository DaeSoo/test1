package com.spring.boot.ui.entity;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum StatusType {

	ready(1),
	delivery(2),
	complete(3);
	
	int value;
	
	StatusType(int value){
		this.value = value;
	}
	
	
	public static StatusType enumOf(int n) {
		return Arrays.stream(StatusType.values())
						.filter(t -> t.getValue() ==n)
						.findAny().orElse(null);
	}
}
