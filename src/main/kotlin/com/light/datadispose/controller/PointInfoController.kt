package com.light.datadispose.controller

import cn.hutool.core.io.FileUtil
import cn.hutool.core.io.file.FileNameUtil
import cn.hutool.core.lang.id.NanoId
import com.light.datadispose.model.MyResult
import com.light.datadispose.model.point.Point
import com.light.datadispose.service.point.PointInfoService
import com.light.datadispose.service.point.PointService
import com.light.datadispose.utils.saveFile

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.text.SimpleDateFormat
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.name

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("api/point")
class PointInfoController(
    val ps: PointService,

    val pis: PointInfoService,

    @Value("\${uploadFileDir}")
    val AppDir: String,
    @Value("\${imageDir}")
    val imageDir: String,
    @Value("\${staticPrefix}")
    val staticPrefix: String,
    @Value("\${tempUploadFileDir}")
    val tempAppdir: String,
) {
    @PostMapping("/{id}")
    fun uploadInfo(@RequestBody point: Point, @PathVariable("id") dId: Int) = kotlin.runCatching {
        point.apply {
            deptId = dId
            points.forEach {
                it.pointId = id
            }

            if (iconImage.startsWith( tempAppdir)) {
                iconImage ="/"+Path(AppDir).relativize(
                    iconImage?.let {
                        Files.copy(Path(AppDir, it), Path(
                            AppDir, imageDir,
                            SimpleDateFormat("yyyy/MM/dd").format(Date()), FileUtil.getName(it)
                        ).apply { parent?.createDirectories() }, StandardCopyOption.REPLACE_EXISTING
                        )
                    }!!
                ).toString()
            }
            if (showImage.startsWith( tempAppdir)) {
                showImage = "/"+Path(AppDir).relativize(
                    showImage?.let {
                        Files.copy(Path(AppDir, it),
                            Path(
                                AppDir, imageDir, SimpleDateFormat("yyyy/MM/dd").format(Date()), FileUtil.getName(it),
                            ).apply { parent?.createDirectories() }, StandardCopyOption.REPLACE_EXISTING
                        )
                    }!!
                ).toString()
            }
        }
        //保存
        ps.saveOrUpdate(point)
        if (point.points != null)
            pis.saveOrUpdateBatch(point.points)
        MyResult.ok().apply {
            data = point.points
        }
    }.onFailure {
        logger.error { it }
    }.getOrDefault(MyResult.Error())

    @GetMapping("/{id}")
    fun listALlByDeptID(@PathVariable("id")id:Int)=
         MyResult.ok().apply { data=ps.findAllByDeptId(id) }

    @DeleteMapping("pointinfoid/{id}")
    fun deletePointInfoById(@PathVariable("id") id:Int): MyResult? {
        if(pis.removeById(id))
            return MyResult.ok()
        else
            return MyResult.Error()
    }

    @DeleteMapping("{id}")
    fun deletePointById(@PathVariable("id") id:String): MyResult? {
        val byId = ps.getById(id)
        if (ps.removeById(id)) {
            kotlin.runCatching {
                Files.delete(Path(AppDir,byId.showImage))

            }.onFailure {
                logger.error { it }
            }
            kotlin.runCatching {
                Files.delete(Path(AppDir,byId.iconImage))
            }.onFailure {
                logger.error { it }
            }

            return MyResult.ok()
        }
        else
            return MyResult.Error()
    }

    @PostMapping("deptimage/{id}")
    fun deptImage(@RequestParam("file") mf: MultipartFile,@PathVariable("id") id:Int){
       val url=saveFile(file = mf, NanoId.randomNanoId()+ "."+FileNameUtil.getSuffix(mf.originalFilename),AppDir,imageDir)?.let {
           Path(AppDir).relativize(it.toPath())
       }

    }
}
