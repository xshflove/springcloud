package com.xsf.order_service.feign;

import com.xsf.order_service.config.uploadConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ShiFeng.Xu
 * @date 2019/12/22
 */
@FeignClient(name = "product",configuration = uploadConfig.class )
public interface ProductFeignClient {

    @RequestMapping(value = "/product/buy")
    public String buyProduct();

    @PostMapping(value = "/product/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart(value = "file")MultipartFile file);


}
