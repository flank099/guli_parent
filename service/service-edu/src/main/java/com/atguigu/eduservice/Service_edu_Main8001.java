package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.alibaba.nacos.registry.NacosAutoServiceRegistration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author flank
 * @description
 * @create 2022-10-04 10:32
 */
@SpringBootApplication()
@ComponentScan(basePackages = "com.atguigu")
public class Service_edu_Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Service_edu_Main8001.class,args);
    }
}