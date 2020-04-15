package com.xsf.order_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsf.product_service.controller.TestDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author ShiFeng.Xu
 * @date 2020/3/25
 */
@Component
public class DirectReceiver {
    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(Message testMessage) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String messaged=new String(testMessage.getBody());
        TestDTO student=mapper.readValue(messaged.getBytes("utf-8"),TestDTO.class);
        System.out.println("DirectReceiver消费者收到消息  : " + student.getAge());
    }

}
