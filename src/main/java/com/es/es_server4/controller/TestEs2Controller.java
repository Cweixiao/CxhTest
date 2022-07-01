package com.es.es_server4.controller;

import com.es.es_server4.model.pojo.TestEs2;
import com.es.es_server4.service.TestEs2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestEs2Controller {
    @Autowired
    TestEs2Service testEs2Service;  //需要在TestEs2Service或者实现类中声明，那是Service,,否则spring不知道他是不是Service


    @GetMapping("/getTestEs2")
    @ResponseBody
    public TestEs2 testEs2(){
        return testEs2Service.getTestEs2();
    }

}
