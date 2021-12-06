package com.org.Demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xujiafu
 * @date 2021/11/27 16:23
 */
@SpringBootApplication
@MapperScan("com.org.Demo.mp.mappers")
public class TiDBDemo {

    public static void main(String[] args) {
        SpringApplication.run(TiDBDemo.class, args);
    }

}
