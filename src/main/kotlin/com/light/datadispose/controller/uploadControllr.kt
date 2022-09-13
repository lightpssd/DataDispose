package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.utils.savaTemp
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

import kotlin.io.path.name

@RestController
@RequestMapping("api")
class uploadControllr(
    @Value("\${uploadFileDir}")
    val Appdir:String,
    @Value("\${tempUploadFileDir}")
    val tempAppdir:String,

) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("upload")
    fun uploadFile(@RequestParam("file") mf: MultipartFile)= kotlin.runCatching{
        checkNotNull(savaTemp(mf,Appdir+tempAppdir)){
            logger.error { "上传失败！" }
            TODO()
        }.let {
            MyResult.ok().apply {
                data = tempAppdir+"/"+it.name
                msg = "成功！"
            }
        }
    }
}
