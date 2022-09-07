package com.light.datadispose.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/")
class untilsController {
    @GetMapping("uuid")
    fun getUuid()=UUID.randomUUID()

}