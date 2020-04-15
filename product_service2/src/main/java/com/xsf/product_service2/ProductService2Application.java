package com.xsf.product_service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductService2Application.class, args);
    }

}
