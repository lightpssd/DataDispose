package com.light.datadispose.service.maintain.impl


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.maintain.ChangePointMapper
import com.light.datadispose.model.maintain.ChangePoint
import com.light.datadispose.service.maintain.IChangePointService
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
open class ChangePointServiceImpl : ServiceImpl<ChangePointMapper, ChangePoint>(), IChangePointService {

}
