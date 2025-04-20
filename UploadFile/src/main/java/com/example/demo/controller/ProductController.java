package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")

	public ResponseEntity<SuccessResponse> addProduct(@RequestPart ProductDto productDto,
			@RequestPart MultipartFile multipartFile) throws IOException {
		ProductDto product = productService.addProduct(productDto, multipartFile);
		if (product != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Added", product), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Added", null), HttpStatus.BAD_REQUEST);

	}

}
