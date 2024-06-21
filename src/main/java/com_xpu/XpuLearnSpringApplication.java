package com_xpu;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com_xpu.mapper")
@SpringBootApplication
public class XpuLearnSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(XpuLearnSpringApplication.class, args);
    }

}
