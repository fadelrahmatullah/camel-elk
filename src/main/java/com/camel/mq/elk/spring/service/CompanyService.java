package com.camel.mq.elk.spring.service;

import java.util.List;

import com.camel.mq.elk.spring.entity.Company;

public interface CompanyService {
    void bulkInsertCompany(List<Company> companies);
}
