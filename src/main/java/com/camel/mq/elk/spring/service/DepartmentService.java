package com.camel.mq.elk.spring.service;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.camel.mq.elk.spring.entity.Department;

public interface DepartmentService {
    
    void bulkInsertDepartment(List<Department> departments);
    Department findByDepartmentCode(@NotBlank String departmentCode);
}
