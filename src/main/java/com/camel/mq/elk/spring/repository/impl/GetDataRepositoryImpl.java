package com.camel.mq.elk.spring.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.camel.mq.elk.spring.repository.GetDataRepository;

@Repository
public class GetDataRepositoryImpl implements GetDataRepository{

    @Autowired
	private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> executeQuery() {
        return jdbcTemplate.queryForList("select td.dpt_name, td.dpt_code, tc.company_name from t_department td join t_company tc on td.id = tc.dpt_id ");
    }
    
}
