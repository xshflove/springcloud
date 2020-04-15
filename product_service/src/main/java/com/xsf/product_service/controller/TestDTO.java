package com.xsf.product_service.controller;

import java.io.Serializable;

/**
 * @author ShiFeng.Xu
 * @date 2020/3/26
 */
public class TestDTO implements Serializable {

    private String name;

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
