package com.light.datadispose.controller.testController;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import com.light.datadispose.model.MyResult;
import com.light.datadispose.service.funService.TestFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@ShowFunAble(name = "测试模块标题",description = "测试模块")
@RequestMapping("/test")
public class TestAysncController {

    @Autowired
    @Qualifier("verificationRunning")
    Consumer<String> isRunning;

    @Autowired
    TestFunService ts;

    @ShowFunAble(name="测试功能标题",description = "测试功能")
    @GetMapping("/1")
    public MyResult test1(){
        isRunning.accept("com.light.datadispose.service.funService.TestFunService.test1");
        ts.test1();
        return MyResult.ok();
    }
}
