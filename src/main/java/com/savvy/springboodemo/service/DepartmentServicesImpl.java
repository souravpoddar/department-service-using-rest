package com.savvy.springboodemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvy.springboodemo.controller.DepartmentController;
import com.savvy.springboodemo.entity.Department;
import com.savvy.springboodemo.repository.DepartmentRepository;

@Service
public class DepartmentServicesImpl implements DepartmentServices{
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Override
	public Department saveDepartment(Department department) {
		LOGGER.info("Inside save department function"+department.getDepartmentCode());
		department.setId(UUID.randomUUID());
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentById(UUID departmentId) {
		return departmentRepository.findById(departmentId);
	}

	@Override
	public void deleteDepartmentById(UUID departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(UUID departmentId, Department department) {
		departmentRepository.save(department);
		return null;
	}
}
