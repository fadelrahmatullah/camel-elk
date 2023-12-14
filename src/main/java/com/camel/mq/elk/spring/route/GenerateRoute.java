package com.camel.mq.elk.spring.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.mq.elk.spring.constants.Constants;
import com.camel.mq.elk.spring.processor.GenerateProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GenerateRoute extends RouteBuilder{

    @Autowired
    private GenerateProcessor generateProcessor;
    
    @Override
    public void configure() throws Exception {

        log.info("CSV Route created..");

        log.info("process RCA NEW SCORE indicator queue..");
        from("activemq:"+Constants.QUEUE_MSG_1)
                .process(generateProcessor);

        // from("file:"+Constants.FILE_DIRECT+"?"+
        //     "recursive=true").delay(5000)
        // .process(generateProcessor)
        // .to("file:"+Constants.FILE_DIRECT_CAMEL+Constants.FILE_SEPARATOR+"produce-file")
        // .routeId("produceCamelRoute");
    }
    
}
