package com.example.demo.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class StudentsUtils {
	public static File convertMultipartToFile(MultipartFile multipartFile, String fileName) throws IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		multipartFile.transferTo(convFile);
		return convFile;
	}

}
