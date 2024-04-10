package com.savvy.springboodemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.savvy.springboodemo.entity.Department;

public interface DepartmentServices {

	Department saveDepartment(Department department);

	List<Department> getDepartments();

	Optional<Department> getDepartmentById(UUID departmentId);

	void deleteDepartmentById(UUID departmentId);

	Department updateDepartmentById(UUID departmentId, Department department);

}
