package com.atguigu1.boot.controller;

import com.atguigu1.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle(@RequestParam("name") String name) {

        return "Hello , Spring Boot2" + "你好：" + name;
    }


//hanpi
}
