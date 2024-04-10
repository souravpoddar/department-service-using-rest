package com.savvy.springboodemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.savvy.springboodemo.entity.Department;
import com.savvy.springboodemo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServicesTest {
	
	@Autowired
	private DepartmentServices service;
	
	private DepartmentRepository repo;
	
	@BeforeAll
	void setUp() throws Exception {
		
		List<Department> departmentList = new ArrayList<>();
		
		Department department = Department.builder()
				.departmentAddress("Bangalore")
				.departmentCode("IT-06")
				.departmentName("IT")
				.id(UUID.fromString("c6a8669e-ee95-4c42-9ef6-4a9b61380161"))
				.build();
		Department department1 = Department.builder()
				.departmentAddress("Bangalore")
				.departmentCode("CE-07")
				.departmentName("CE")
				.id(UUID.fromString("c6a8669e-ee95-4c42-9ef6-4a9b61380162"))
				.build();
		Department department2 = Department.builder()
				.departmentAddress("Kolkata")
				.departmentCode("IT-06")
				.departmentName("IT")
				.id(UUID.fromString("c6a8669e-ee95-4c42-9ef6-4a9b61380163"))
				.build();
		departmentList.add(department);
		departmentList.add(department1);
		departmentList.add(department2);
		
		Mockito.when(repo.save(department)).thenReturn(department);
		Mockito.when(repo.findAll()).thenReturn(departmentList);
		Mockito.when(repo.findById(UUID.fromString("c6a8669e-ee95-4c42-9ef6-4a9b61380161"))).thenReturn(Optional.of(department));
	}

	@Test
	void testSaveDepartment() {
		Department departmentreq = Department.builder()
				.departmentAddress("Bangalore")
				.departmentCode("IT-06")
				.departmentName("IT")
				.build();
		Department department = service.saveDepartment(departmentreq);
		assertEquals(department.getId(), 1L);
	}

	@Test
	void testGetDepartments() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDepartmentById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDepartmentById() {
		fail("Not yet implemented");
	}

}
