package com.light.datadispose;

import com.light.datadispose.mapper.cloudnote.AuthGroupMapper;
import com.light.datadispose.mapper.newDay.UserMapper;
import com.light.datadispose.model.cloudnote.AuthGroup;
import com.light.datadispose.service.funService.TestFunService;
import com.light.datadispose.service.newDay.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Properties;

@SpringBootTest
class DataDisposeApplicationTests {

    @Autowired
    TestFunService testFunService;

    @Test
    void contextLoads() {
        File file = new File("file:///C:/Users/Light/Desktop/桌面项目集合/DataDispose/fDCAMgZ9aJblihUloTD3H6744241734210044573.png");
        Properties properties = System.getProperties();
        properties.entrySet().forEach(b->{
            System.out.println(b.getKey()+":"+b.getValue());
        });

    }

}
