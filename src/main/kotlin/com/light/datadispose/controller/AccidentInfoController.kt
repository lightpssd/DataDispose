package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.service.maintain.IAccidentInfoService
import com.light.datadispose.service.maintain.impl.AccidentInfoServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author light
 * @since 2022-10-22
 */
@RestController
@RequestMapping("api/accidentInfo")
class AccidentInfoController{

    @Autowired
    lateinit var AS: IAccidentInfoService

    @GetMapping
    fun getAccidentInfo(id:Int)=kotlin.runCatching {
         AS.getById(id)?.run { MyResult.ok().apply { data=this@run } }?:MyResult.Error().apply { msg="获取失败" }
    }.onFailure {

    }.getOrNull()?:MyResult.Error().apply { msg="获取失败" }
}
