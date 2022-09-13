package com.light.datadispose.service.point.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.point.PointInfoMapper;
import com.light.datadispose.mapper.point.PointMapper;
import com.light.datadispose.model.point.Point;
import com.light.datadispose.model.point.PointInfo;
import com.light.datadispose.service.point.PointInfoService;
import com.light.datadispose.service.point.PointService;
import org.springframework.stereotype.Service;

@DS("point")
@Service
public class PointInfoServiceImpl extends ServiceImpl<PointInfoMapper, PointInfo> implements PointInfoService {
}
