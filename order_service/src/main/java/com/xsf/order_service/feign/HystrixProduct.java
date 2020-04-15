package com.xsf.order_service.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ShiFeng.Xu
 * @date 2019/12/26
 */
@Service
public class HystrixProduct implements ProductFeignClient {
    @Override
    public String buyProduct() {
        return "商品服务不可用，熔断";
    }

    @Override
    public String upload(MultipartFile file) {
        return "失败";
    }
}
