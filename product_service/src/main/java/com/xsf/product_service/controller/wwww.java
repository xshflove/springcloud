package com.xsf.product_service.controller;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShiFeng.Xu
 * @date 2020/3/27
 */
public class wwww {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>(); 
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(StringUtils.join(list,","));
    }
}
