package com.light.datadispose.controller.testController;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ShowFunAble(name = "测试")
@RequestMapping("/test")
public class testAysncService {

    @GetMapping("/1")
    public void test1(){

    }
}
