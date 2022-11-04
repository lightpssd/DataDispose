package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.utils.defaultImageList
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * ClassName: defaultImageController
 * Author: 光子
 * Date:  2022/11/3
 * Project DataDispose
 **/
private val logger = KotlinLogging.logger {}
@RestController
@RequestMapping("/api/defimagelist")
class defaultImageController(
    @Value("\${uploadFileDir}")
    val Appdir: String,
    @Value("\${defaultImageDir}")
    val defAppdir: String,
) {
    @GetMapping
    fun defList()=kotlin.runCatching{

        defaultImageList(Appdir,defAppdir).let{
            return@runCatching MyResult.ok().apply { data=it }
        }
    }.onFailure {
        logger.error { "获取默认图标错误" }
    }.getOrNull()?:MyResult.Error()

}
