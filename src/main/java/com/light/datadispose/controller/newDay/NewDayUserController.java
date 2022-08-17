package com.light.datadispose.controller.newDay;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NewDayUser")
@ShowFunAble
public class NewDayUserController {
    @GetMapping
    public String test(){
        return "asda";
    }
}
