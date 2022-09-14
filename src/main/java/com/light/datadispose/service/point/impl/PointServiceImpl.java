package com.light.datadispose.service.point.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.light.datadispose.mapper.point.PointMapper;
import com.light.datadispose.model.point.Point;
import com.light.datadispose.service.point.PointService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DS("point")
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point> implements PointService {
    @Autowired
    PointMapper pm;
    @Override
    public List<Point> findAllByDeptId(Integer deptId) {
        return pm.findAllByDeptId(deptId);
    }
}
