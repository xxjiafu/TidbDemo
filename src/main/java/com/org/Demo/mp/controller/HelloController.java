package com.org.Demo.mp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujiafu
 * @date 2021/12/3 22:05
 */

@RestController

public class HelloController {

    @RequestMapping("/Hello")
    public String sayHello(){
        return "hello world!!!!";

    }
}
