package com.light.datadispose;

import com.light.datadispose.mapper.cloudnote.AuthGroupMapper;
import com.light.datadispose.mapper.newDay.UserMapper;
import com.light.datadispose.model.cloudnote.AuthGroup;
import com.light.datadispose.service.newDay.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataDisposeApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    AuthGroupMapper authGroupMapper;

    @Test
    void contextLoads() {
        AuthGroup authGroup = new AuthGroup();
        authGroup.setId(2);
        authGroup.setName("asd");
        authGroupMapper.insert(authGroup);
    }

}
