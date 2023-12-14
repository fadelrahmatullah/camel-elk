package com.camel.mq.elk.spring.constants;

public interface Constants {
    
    /* LOCAL */
    final String FILE_SEPARATOR = System.getProperty("file.separator"); 
    final String USER_SYSTEM = System.getProperty("user.dir");
    final String USER_LOCAL = System.getProperty("user.home");

    /* DIRECT FILE 1*/
    final String FILE_DIRECT = USER_SYSTEM + FILE_SEPARATOR + "CSV";
    /* DIRECT FILE 2*/
    final String FILE_DIRECT_CAMEL = FILE_DIRECT + FILE_SEPARATOR + "CAMEL";

    // que msg
    final String QUEUE_MSG_1 = "queue-msg1";
}
