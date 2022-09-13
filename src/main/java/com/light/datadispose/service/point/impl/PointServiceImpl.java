package com.light.datadispose.service.point.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.point.PointMapper;
import com.light.datadispose.model.point.Point;
import com.light.datadispose.service.point.PointService;
import org.springframework.stereotype.Service;

@DS("point")
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point> implements PointService {

}
