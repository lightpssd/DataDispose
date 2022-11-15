package com.light.datadispose.service.maintain.impl


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.maintain.EqInfoMapper
import com.light.datadispose.model.maintain.EqInfo
import com.light.datadispose.service.maintain.IEqInfoService
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author light
 * @since 2022-11-14
 */
@Service
open class EqInfoServiceImpl : ServiceImpl<EqInfoMapper, EqInfo>(), IEqInfoService {

}
