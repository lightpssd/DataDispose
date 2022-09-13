package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.model.point.Point
import com.light.datadispose.service.point.PointInfoService
import com.light.datadispose.service.point.PointService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import kotlin.io.path.Path

private val logger = KotlinLogging.logger {}
@RestController
@RequestMapping("api/point")
class PointInfoController(
    val ps:PointService,
    val pis:PointInfoService,
    @Value("\${uploadFileDir}")
    val AppDir:String,
    @Value("\${imageDir}")
    val imageDir:String,
    @Value ("\${staticPrefix}")
    val staticPrefix:String
) {
    @PostMapping("/{id}")
    fun uploadInfo(@RequestBody point:Point,@PathVariable("id") dId:Int )=kotlin.runCatching{
        point.apply {
            deptId=dId
            points.forEach {
                it.pointId=id
            }
            println(AppDir)
//            Files.move()
        }


        //保存
        ps.saveOrUpdate(point)
        pis.saveOrUpdateBatch(point.points)
        MyResult.ok().apply {
            data=point.points
        }
    }.onFailure {
        logger.error { it }
    }.getOrDefault(Result)
}
