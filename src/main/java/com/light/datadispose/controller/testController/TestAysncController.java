package com.light.datadispose.controller.testController;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import com.light.datadispose.model.Result;
import com.light.datadispose.service.funService.TestFunService;
import com.light.datadispose.utils.FunRunningUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Set;
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
    public Result test1(){
        isRunning.accept("com.light.datadispose.service.funService.TestFunService.test1");
        ts.test1();
        return Result.ok();
    }
}
