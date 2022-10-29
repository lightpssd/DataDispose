package com.light.datadispose.service.maintain.impl


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.maintain.AccidentInfoMapper
import com.light.datadispose.model.maintain.AccidentInfo
import com.light.datadispose.service.maintain.IAccidentInfoService
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author light
 * @since 2022-10-22
 */
@Service
open class AccidentInfoServiceImpl : ServiceImpl<AccidentInfoMapper, AccidentInfo>(), IAccidentInfoService {

}
