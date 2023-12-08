package com.camel.mq.elk.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "com.camel.mq.elk.spring.repository")
public class JpaRepositoryConfig {
    
}
