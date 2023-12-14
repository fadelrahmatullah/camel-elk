package com.camel.mq.elk.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camel.mq.elk.spring.messaging.PushMessaging;
import com.camel.mq.elk.spring.vo.ResponseEntityDto;

@RestController
@RequestMapping("/csv")
public class GenerateAndUploadCsvController {

    @Autowired
    private PushMessaging pushMessaging;

    @PostMapping("/produce-camel")
    public ResponseEntityDto<?> uploadAndProduceCamel(){

        return new ResponseEntityDto<>().succesResponse(pushMessaging.executeGenerateCSV("routeId_1"));
    }

}
