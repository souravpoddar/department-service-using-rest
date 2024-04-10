package com.savvy.springboodemo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.savvy.springboodemo.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, UUID> {

}
