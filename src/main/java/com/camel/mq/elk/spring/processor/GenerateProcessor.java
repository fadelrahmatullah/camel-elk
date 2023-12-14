package com.camel.mq.elk.spring.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.mq.elk.spring.service.GenerateDataToCsvService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GenerateProcessor implements Processor{

    @Autowired
    private GenerateDataToCsvService generateCsv;
    
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getMessage().getBody().toString();
        log.info("message  = {} ",message);
        generateCsv.generateCsv();
    }
    
}
