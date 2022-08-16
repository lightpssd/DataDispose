package com.light.datadispose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.light.datadispose.mapper")
public class DataDisposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataDisposeApplication.class, args);
    }

}
