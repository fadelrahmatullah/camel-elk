package com.camel.mq.elk.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.camel.mq.elk.spring.entity.Company;
import com.camel.mq.elk.spring.repository.CompanyRepository;
import com.camel.mq.elk.spring.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public void bulkInsertCompany(List<Company> companies) {
        log.info("<<DATA Companies : "+JSON.toJSONString(companies));
        companyRepository.saveAll(companies);
    }
}
