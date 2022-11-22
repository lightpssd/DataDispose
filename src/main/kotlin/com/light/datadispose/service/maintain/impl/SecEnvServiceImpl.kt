package com.light.datadispose.service.maintain.impl


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.light.datadispose.mapper.maintain.SecEnvMapper
import com.light.datadispose.model.maintain.SecEnv
import com.light.datadispose.service.maintain.ISecEnvService
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author light
 * @since 2022-11-22
 */
@Service
open class SecEnvServiceImpl : ServiceImpl<SecEnvMapper, SecEnv>(), ISecEnvService {

}
