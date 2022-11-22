package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.service.maintain.IAccidentInfoService
import com.light.datadispose.service.maintain.ISecEnvService
import com.light.datadispose.utils.getlogger
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
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/api/secEnv")
class SecEnvController {

    val log by getlogger()

    @Autowired
    lateinit var SES: ISecEnvService

    @GetMapping
    fun getses(id: Int) = kotlin.runCatching {
        SES.getById(id)?.run { MyResult.ok().apply { data = this@run } } ?: MyResult.Error().apply { msg = "获取失败" }
    }.onFailure {
        log.error(it.toString())
    }.getOrNull() ?: MyResult.Error().apply { msg = "获取失败" }

}
