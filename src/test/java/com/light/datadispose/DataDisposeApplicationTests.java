package com.light.datadispose;

import com.light.datadispose.mapper.point.PointMapper;
import com.light.datadispose.model.point.Point;
import com.light.datadispose.service.funService.TestFunService;
import com.light.datadispose.service.maintain.IEqInfoService;
import com.light.datadispose.service.point.PointInfoService;
import com.light.datadispose.service.point.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DataDisposeApplicationTests {

    @Autowired
    TestFunService testFunService;

    @Autowired
    PointService ps;

    @Autowired
    PointInfoService pis;
    @Autowired
    PointMapper pm;

    @Autowired
    IEqInfoService iq;
    @Test
    void contextLoads() {
        System.out.println(iq.getById(16));
    }

}
