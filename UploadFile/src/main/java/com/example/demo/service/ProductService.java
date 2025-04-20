package com.example.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDto;

public interface ProductService {
	public ProductDto addProduct(ProductDto productDto, MultipartFile multipartFile) throws IOException;

}
