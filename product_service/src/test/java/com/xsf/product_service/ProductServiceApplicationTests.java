package com.xsf.product_service;

import com.xsf.product_service.controller.TestDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductServiceApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {


//        redisTemplate.opsForValue().set("myKey","myValue");
//        System.out.println(redisTemplate.opsForValue().getAndSet("xsf", "222"));
        System.out.println(redisTemplate.opsForValue().setIfAbsent("xxx","111",100, TimeUnit.SECONDS));
    }

    @Test
    void rabbit(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        TestDTO dto = new TestDTO();
        dto.setAge("1111");
        dto.setName("223sadad");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("TestDirectExchange", "TsestDirectRouting", dto);
    }


}
