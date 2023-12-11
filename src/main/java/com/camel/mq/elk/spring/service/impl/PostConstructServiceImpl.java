package com.camel.mq.elk.spring.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.mq.elk.spring.entity.Company;
import com.camel.mq.elk.spring.entity.Department;
import com.camel.mq.elk.spring.service.CompanyService;
import com.camel.mq.elk.spring.service.DepartmentService;
import com.camel.mq.elk.spring.service.PostConstructService;

@Service
public class PostConstructServiceImpl implements PostConstructService{

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @Override
    @PostConstruct
    public void insertBulkDefaultData() {
        List<Department> departments = new ArrayList<>(
            Arrays.asList(
                new Department("DPT-001", "Menara Research", "Menara Research", "Jl. Mangga Kecil No 001"),
                new Department("DPT-002", "Menara Research Solo", "Menara Research Solo", "Jl. Solo Raya No 001"),
                new Department("DPT-003", "Menara Research Bandung", "Menara Research Bandung", "Jl. Dipatiukur No 001")
            )
        );
        departmentService.bulkInsertDepartment(departments);

        List<Company> companies = new ArrayList<>(
            Arrays.asList(
                new Company(departmentService.findByDepartmentCode("DPT-001"), "PT. Consultan Tekno", "Consultan"),
                new Company(departmentService.findByDepartmentCode("DPT-001"), "PT. Bank Java", "Banking"),
                new Company(departmentService.findByDepartmentCode("DPT-002"), "PT. Tree Source", "Source Human"),
                new Company(departmentService.findByDepartmentCode("DPT-002"), "PT. Mirror White", "Mirror"),
                new Company(departmentService.findByDepartmentCode("DPT-003"), "PT. Golang Tekno", "Consultan Golang")
            )
        );
        companyService.bulkInsertCompany(companies);

    }
    
}
