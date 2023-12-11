package com.camel.mq.elk.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camel.mq.elk.spring.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
    Optional<Department> findByDepartmentCode(String departmentCode);
}
