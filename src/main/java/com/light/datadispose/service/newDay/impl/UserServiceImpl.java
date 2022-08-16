package com.light.datadispose.service.newDay.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.newDay.UserMapper;
import com.light.datadispose.model.newDay.User;
import com.light.datadispose.service.newDay.UserService;
import org.springframework.stereotype.Service;

@DS("note")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
