package com.xsf.product_service.service.impl;

import com.xsf.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ShiFeng.Xu
 * @date 2019/12/21
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public String buyProduct() {
        log.info("开始调用商品服务===============");
        return "商品服务购买商品111";
    }
}
