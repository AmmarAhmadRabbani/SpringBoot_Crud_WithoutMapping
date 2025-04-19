package com.example.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String subject;
	private String body;
}
