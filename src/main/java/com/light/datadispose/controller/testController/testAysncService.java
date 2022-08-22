package com.light.datadispose.controller.testController;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import com.light.datadispose.service.funService.TestFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ShowFunAble(name = "测试")
@RequestMapping("/test")
public class testAysncService {

    @Autowired
    TestFunService ts;

    @ShowFunAble(name="测试")
    @GetMapping("/1")
    public String test1(){
        ts.test1();
        return "AXS";
    }
}
