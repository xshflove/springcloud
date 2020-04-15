package com.xsf.product_service2.controller;




import com.xsf.product_service2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShiFeng.Xu
 * @date 2019/12/21
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("buy")
    public String print(){
        return productService.buyProduct();
    }
}
