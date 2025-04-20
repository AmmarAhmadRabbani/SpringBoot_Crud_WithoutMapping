package com.example.demo.dto;

import com.example.demo.entity.ProductFilesData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
	private String productName;
	private String productType;
	private String brand;

	private ProductFilesData filesData;

}
