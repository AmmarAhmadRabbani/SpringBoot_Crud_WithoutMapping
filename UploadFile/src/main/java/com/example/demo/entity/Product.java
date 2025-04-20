package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Entity
@Table(name = "Product")
@Builder
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private String productType;
	private String brand;
//	private String fileName;
//	private String fileType;
//	@Lob
//	private byte[] fileData;

//	Unidirectional Mapping
	/*
	 * if we use mappedBy with mapping annotations(like- @OneToOne) then the foreign
	 * key will be created in the table for that entity that is associated with
	 * mappedBy. like, here foreign key will be created in the Table FileData but
	 * not in the Product table.
	 */
// we are using cascade with mapping annotations(like-@OneToOne(cascade = CascadeType.PERSIST) to auto save(create)/delete/update/read. 
//	@OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST)
	@OneToOne(cascade = CascadeType.ALL)
//	If we are not using mappedBy with annotations (like- @OneToOne), then the foreign key will appear in the both associated table.Such as foreign key of Entity File will come to the table of Product and vice-versa.
	private ProductFilesData filesData;

}
