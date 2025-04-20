package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "File")

public class ProductFilesData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileId;
	@Column(name = "FileName")
//	@Column annotation is used to rename the column name.
	private String fileName;
	private String fileType;
	@Lob
	private byte[] fileDataStr;

//	Bidirectional Mapping
//	@OneToOne
	/*
	 * Here, we're using @joinColumn annotations to rename the join column name.
	 */
//	@JoinColumn(name = "product_id")
//	private Product product;

}
