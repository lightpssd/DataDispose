package com.light.datadispose.service.funService;

import cn.hutool.core.lang.id.NanoId;
import com.light.datadispose.mapper.newDay.UserMapper;
import com.light.datadispose.model.newDay.User;
import com.light.datadispose.service.IFunService;
import com.light.datadispose.service.newDay.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.stream.IntStream;


@Service
public class TestFunService implements IFunService {

    @Autowired
    UserService us;
    @Autowired
    UserMapper um;
    @Async("MainExecutor")
    public void test1(){
        IntStream.range(400,500).forEach((a)->{
            User user = new User();
            user.setName("ppp");
            um.insert(user);
        });

    }
}
