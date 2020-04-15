package com.xsf.order_service.controller;

import com.xsf.order_service.feign.ProductFeignClient;
import com.xsf.order_service.service.OrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ShiFeng.Xu
 * @date 2019/12/21
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderSerivce orderSerivce;
//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    ProductFeignClient productFeignClient;
    @GetMapping("buy")
    public String buyProduct(){
//        List<ServiceInstance> list = discoveryClient.getInstances("PRODUCT");
//
//        ServiceInstance instance = list.get(0);
//        System.out.println(instance.getUri());
//        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/buy",String.class);
//        return restTemplate.getForObject("http://PRODUCT/product/buy",String.class);
        return productFeignClient.buyProduct();
    }

    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(value = "file")MultipartFile file){
        return productFeignClient.upload(file);
    }

}
