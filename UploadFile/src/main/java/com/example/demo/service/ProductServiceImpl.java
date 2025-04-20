package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductFilesData;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.FilesDataRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private FilesDataRepository filesDataRepository;

	@Override
	public ProductDto addProduct(ProductDto productDto, MultipartFile multipartFile) throws IOException {
		if (productDto != null) {

			Product product = new Product();
			BeanUtils.copyProperties(productDto, product);
			ProductFilesData filesDataDto = productDto.getFilesData();
			ProductFilesData productFilesData = new ProductFilesData();
//			productFilesData.getFileDataStr(productFilesData.setFileDataStr(
//					ProductFilesData.builder().fileDataStr(FileUtils.compressFile(multipartFile.getBytes())).build()));
//			productFilesData.setFileDataStr(
//					ProductFilesData.builder().fileDataStr(FileUtils.compressFile(multipartFile.getBytes())).build());
			BeanUtils.copyProperties(filesDataDto, productFilesData);
			product.setFilesData(productFilesData);
//			filesData.setFileDataStr(
//					FilesData.builder().fileDataStr(FileUtils.compressFile(multipartFile.getBytes())).build());
			/*
			 * filesDataRepository
			 * .save(FilesData.builder().fileData(FileUtils.compressFile(multipartFile.
			 * getBytes())).build());
			 */
			productRepository.save(product);
			BeanUtils.copyProperties(product, productDto);
			return productDto;

		}
		throw new ProductNotFoundException("Invalid Product");
	}

}
