package com.camel.mq.elk.spring.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.mq.elk.spring.constants.Constants;
import com.camel.mq.elk.spring.processor.PushCamelProcessor;

@Component
public class PushFileProduceRoute extends RouteBuilder{

    @Autowired
    private PushCamelProcessor pushCamelProcessor;

    @Override
    public void configure() throws Exception {
        log.info("PushCamelRoute created..");
        String prefix = "&antInclude=**/filecsvCamel*.csv";
        from("file:"+Constants.FILE_DIRECT+"?"+
            "preMove=processing&readLock=changed"+prefix+
            "&move="+Constants.FILE_DIRECT_CAMEL+Constants.FILE_SEPARATOR+"${file:name}"
        ).delay(5000).process(pushCamelProcessor);
    }
    
}
