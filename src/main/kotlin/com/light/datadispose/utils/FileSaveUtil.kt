package com.light.datadispose.utils

import cn.hutool.core.io.file.FileNameUtil
import cn.hutool.core.lang.id.NanoId
import mu.KotlinLogging
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.createTempDirectory
import kotlin.io.path.div
private val logger = KotlinLogging.logger {}
/**
 * 保存到临时目录，返回保存的位置
 */
fun savaTemp(file: MultipartFile,tdir:String)= runCatching {
    kotlin.io.path.createTempFile(Path(tdir).apply { createDirectories()
    },NanoId.randomNanoId(),'.'+FileNameUtil.getSuffix(file.originalFilename)).apply{
        file.transferTo(this)
    }
}.onFailure {
    logger.error { "创建文件错误！" }
}.getOrNull()

/**
 * 保存文件到正式目录，返回保存的File对象
 */
fun saveFile(file: MultipartFile,fileName:String,base:String,vararg dir:String)= runCatching{
    (Path(base,*dir).createDirectories()/fileName).apply {
        file.transferTo(this)
    }.toFile()
}







