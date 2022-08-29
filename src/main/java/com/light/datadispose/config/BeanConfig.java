package com.light.datadispose.config;

import com.light.datadispose.model.ShowFun;
import com.light.datadispose.utils.FunRunningUtil;
import com.light.datadispose.utils.FunUrlUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class BeanConfig {


    /**
     * 正在运行的功能的激活
     * @return 返回一个@{@link HashSet}集合
     */
    @Bean
    public Set<String> runFunSet(){
        return new HashSet<>();
    }


    @Bean("controllerShowList")
    public List<ShowFun> cShowFun(){
        return FunUrlUtil.controllerShowList;
    }

    @Bean("verificationRunning")
    public  Consumer<String> funIsRunning(Set<String> rfSet){
        return s -> FunRunningUtil.FunIsRunning(rfSet, s);
    }
}
