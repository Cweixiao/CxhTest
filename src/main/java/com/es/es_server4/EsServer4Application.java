package com.es.es_server4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.es.es_server4.model.dao")     //告诉mybatis哪里是mapper类，
public class EsServer4Application {

    public static void main(String[] args) {
        SpringApplication.run(EsServer4Application.class, args);
    }

}
