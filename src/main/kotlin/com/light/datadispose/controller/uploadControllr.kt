package com.light.datadispose.controller

import com.light.datadispose.utils.savaTemp
import mu.KotlinLogging
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.copyTo

import kotlin.io.path.name

@RestController
@RequestMapping("api")
class uploadControllr(
    @Value("\${uploadFileDir}")
    val Appdir:String,
    @Value("\${tempUploadFileDir}")
    val tempAppdir:String,
    @Value("\${spring.mvc.static-path-pattern}")
    val staticPath:String
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("upload")
    fun uploadFile(@RequestParam("file") mf: MultipartFile)= kotlin.runCatching{
        checkNotNull(savaTemp(mf,Appdir+tempAppdir)){
            logger.error { "上传失败！" }
            TODO()
        }.let {
            com.light.datadispose.model.Result.ok().apply {
                data = tempAppdir+"/"+it.name
                msg = "成功！"
            }
        }
    }
}
