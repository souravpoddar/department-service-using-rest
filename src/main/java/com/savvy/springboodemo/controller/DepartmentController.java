package com.savvy.springboodemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savvy.springboodemo.entity.Department;
import com.savvy.springboodemo.error.DepartmentNotFoundException;
import com.savvy.springboodemo.service.DepartmentServices;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/department")
@NoArgsConstructor
@Slf4j
public class DepartmentController {
	private DepartmentServices departmentService;
	@Autowired
	public DepartmentController(DepartmentServices departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@PostMapping("")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("from department controller");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("")
	public List<Department> getDepartment(){
		return departmentService.getDepartments();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") UUID departmentId) throws DepartmentNotFoundException{
		Optional<Department> department = departmentService.getDepartmentById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department with ID "+departmentId+" not found");
		}
		return department.get();
	}
	
	@DeleteMapping("/{id}") 
	public void deleteDepartmentById(@PathVariable("id") UUID departmentId){
		departmentService.deleteDepartmentById(departmentId);
	}
	
	@PutMapping("/{id}")
	public Department updateDepartmentById(@PathVariable("id") UUID departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}
}
