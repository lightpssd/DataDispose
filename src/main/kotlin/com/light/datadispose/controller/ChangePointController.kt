package com.light.datadispose.controller

import com.light.datadispose.model.MyResult
import com.light.datadispose.service.maintain.IChangePointService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author light
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/api/changePoint")
class ChangePointController {

    @Autowired
    lateinit var cps: IChangePointService

    @GetMapping
    fun getById(id: Int): MyResult {
        try {
            return MyResult.ok().apply {  data=cps.getById(id)}
        }
        catch (e:Exception){
            return MyResult.Error()
        }
    }

}
