package com.light.datadispose.controller.maintain

import com.light.datadispose.mapper.maintain.AccidentInfoMapper
import com.light.datadispose.service.maintain.IAccidentInfoService
import com.light.datadispose.service.maintain.IChangePointService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * ClassName: 安全问题测试
 * Author: 光子
 * Date:  2022/10/22
 * Project DataDispose
 **/

@SpringBootTest
class 安全问题测试 {

    @Autowired
    lateinit var AM:AccidentInfoMapper
    @Autowired
    lateinit var AS:IAccidentInfoService

    @Autowired
    lateinit var CPS:IChangePointService
    @Test
    fun start(){
       println(CPS.getById(10))
    }
}
