package com.light.datadispose.controller


import com.light.datadispose.model.MyResult
import com.light.datadispose.service.maintain.IEqInfoService
import com.light.datadispose.service.maintain.IHazardSourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author light
 * @since 2022-11-14
 */
@RestController
@RequestMapping("/api/hazardSource")
class HazardSourceController{
    @Autowired
    lateinit var hs: IHazardSourceService

    @GetMapping
    fun getHistoryExample(id:Int)=kotlin.runCatching{
        hs.getById(id)
    }.onFailure {

    }.getOrNull()?.run { MyResult.ok().apply { data=this@run } }?: MyResult.Error()

}
