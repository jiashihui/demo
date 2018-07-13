package com.example.demo.controller;

import com.example.demo.test.KotlinTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value="/get", method = RequestMethod.GET)
    @ResponseBody
    public String getValue(){
        KotlinTest kt = new KotlinTest();
        return kt.getStr();
    }

}
