package com.light.datadispose.generate

import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine

fun main() {
    FastAutoGenerator.create("jdbc:mysql://192.9.200.50:3306/maintain?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","jsjk*888").globalConfig {
        it->it.author("light").outputDir("D://小说").enableKotlin()
    }.templateEngine(FreemarkerTemplateEngine()).execute()
}
