package com.hxw.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/13
 **/
@RestController
@RequestMapping("/start")
public class testController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return ":test";
    }
}
