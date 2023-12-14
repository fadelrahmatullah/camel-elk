package com.camel.mq.elk.spring.repository;

import java.util.List;
import java.util.Map;

public interface GetDataRepository {

    List<Map<String, Object>> executeQuery();
} 
