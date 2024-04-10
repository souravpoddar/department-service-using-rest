package com.savvy.springboodemo.entity;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
	@Id
	private UUID id;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	
}
