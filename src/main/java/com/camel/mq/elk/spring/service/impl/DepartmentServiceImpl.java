package com.camel.mq.elk.spring.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.camel.mq.elk.spring.entity.Department;
import com.camel.mq.elk.spring.repository.DepartmentRepository;
import com.camel.mq.elk.spring.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void bulkInsertDepartment(List<Department> departments) {
        log.info("<<DATA Departments : "+JSON.toJSONString(departments));
        departmentRepository.saveAll(departments);
    }

    @Override
    public Department findByDepartmentCode(String departmentCode) {
        Optional<Department> department = departmentRepository.findByDepartmentCode(departmentCode);

        if (!department.isPresent()) {
            return null;
        }
        return department.get();
    }
}
