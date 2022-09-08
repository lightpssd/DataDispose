package com.light.datadispose.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/point")
class PointInfoController {

    @PostMapping
    fun uploadInfo(@RequestBody map:Map<Any,Any>){
        println(map)
    }
}
