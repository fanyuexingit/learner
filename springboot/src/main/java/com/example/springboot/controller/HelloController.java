/**
 * @description:
 * @author: Andy
 * @time: 2021/02/22 14:30
 */
package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanyuexin on 2021/02/22
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        System.out.println(name);
        return "Hello World";
    }

    @Value(value = "com.fam.hhh")
    private String name;

}
