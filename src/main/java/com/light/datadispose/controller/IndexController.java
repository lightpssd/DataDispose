package com.light.datadispose.controller;

import com.light.datadispose.model.Result;
import com.light.datadispose.model.ShowFun;
import com.light.datadispose.model.StateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class IndexController{


    @Autowired
    @Qualifier("controllerShowList")
    private List<ShowFun> funList;

    @Autowired
    Set<String> stringSet;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("funlist",funList);
        return "index";
    }
    @GetMapping("/taskall")
    @ResponseBody
    public Result taskList(){
        return new Result(StateCode.OK,"",stringSet);
    }


}
