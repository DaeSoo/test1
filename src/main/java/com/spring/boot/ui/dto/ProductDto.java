package com.spring.boot.ui.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Setter
@Getter
public class ProductDto {

    private String name;

    private Long price;

    private String description;

    private String imageUrl;

    private String color;

    private String size;

    private Long discount;

    private Long categoryId;

    private Long discountPrice;

}