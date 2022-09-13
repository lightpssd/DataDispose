package com.light.datadispose;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.light.datadispose.mapper.cloudnote.AuthGroupMapper;
import com.light.datadispose.mapper.newDay.UserMapper;
import com.light.datadispose.mapper.point.PointMapper;
import com.light.datadispose.model.cloudnote.AuthGroup;
import com.light.datadispose.model.point.Point;
import com.light.datadispose.model.point.PointInfo;
import com.light.datadispose.service.funService.TestFunService;
import com.light.datadispose.service.newDay.UserService;
import com.light.datadispose.service.point.PointInfoService;
import com.light.datadispose.service.point.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.sql.Wrapper;
import java.util.List;
import java.util.Properties;

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

    @Test
    void contextLoads() {

//        PointInfo pointInfo = new PointInfo();
//        pointInfo.setKey("sadasd");
//        pointInfo.setValue("asdas");
//        pointInfo.setPointId("sadasd");
//        pis.saveOrUpdate(pointInfo);
        List<Point> allByDeptId = pm.findAllByDeptId(10);
        System.out.println(allByDeptId);
//        List<PointInfo> list = pis.list();
//        System.out.println(list);
    }

}
