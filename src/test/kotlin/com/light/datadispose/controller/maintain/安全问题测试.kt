package com.light.datadispose.controller.maintain

import cn.hutool.core.img.ImgUtil.slice
import com.light.datadispose.mapper.maintain.AccidentInfoMapper
import com.light.datadispose.service.maintain.IAccidentInfoService
import com.light.datadispose.service.maintain.IChangePointService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.io.path.Path
import kotlin.io.path.forEachDirectoryEntry
import kotlin.io.path.isDirectory
import kotlin.io.path.listDirectoryEntries

/**
 * ClassName: 安全问题测试
 * Author: 光子
 * Date:  2022/10/22
 * Project DataDispose
 **/
fun main() {
    Path("D:\\upload\\adasd").run {

        listDirectoryEntries().map {
            if (it.isDirectory() && it.listDirectoryEntries().count { !it.isDirectory() }!=0){
                buildMap<String,Any> {
                    this["label"]=it.fileName.toString()
                    this["value"]=it.fileName.toString()
                    this["children"]=it.listDirectoryEntries().filter { !it.isDirectory() }.map {
                            buildMap {
                                val label = it.fileName.toString().dropLastWhile { it != '.' }.removeSuffix(".")
                                this["label"]= if(label.isEmpty())it.fileName.toString() else label
                                this["value"]=Path("D:\\upload").relativize(it).toString().replace("\\","/")

                            }

                        }
                    }
                }
            else{
                buildMap {
                    val label = it.fileName.toString().dropLastWhile { it != '.' }.removeSuffix(".")
                    this["label"]= if(label.isEmpty())it.fileName.toString() else label
                    this["value"]=Path("D:\\upload").relativize(it).toString().replace("\\","/")

                }
            }
        }
    }.let { println(it) }
}
