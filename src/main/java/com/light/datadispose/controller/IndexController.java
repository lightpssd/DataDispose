package com.light.datadispose.controller;

import com.light.datadispose.controller.newDay.NewDayUserController;
import com.light.datadispose.lightAnnotation.ShowFunAble;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ShowFunAble
@RequestMapping("asdas/")
public class IndexController{


    @GetMapping("index")
    public String Index(){
        return "index";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }


}
