package com.camel.mq.elk.spring.messaging;

import com.camel.mq.elk.spring.constants.Constants;
import com.camel.mq.elk.spring.vo.ResponseGenerateCsv;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PushMessaging {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Async
    public ResponseGenerateCsv executeGenerateCSV(String routeId){
        log.info("send queue {} - payload route : {}",Constants.QUEUE_MSG_1, routeId);
        jmsTemplate.convertAndSend(Constants.QUEUE_MSG_1, routeId);
        return new ResponseGenerateCsv(true);
    }
}
