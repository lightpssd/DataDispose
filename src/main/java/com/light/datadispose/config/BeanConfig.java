package com.light.datadispose.config;

import com.light.datadispose.model.ShowFun;
import com.light.datadispose.utils.FunUrlUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfig {

    @Bean("controllerShowList")
    public List<ShowFun> cShowFun(){
        return FunUrlUtil.controllerShowList;
    }
}
