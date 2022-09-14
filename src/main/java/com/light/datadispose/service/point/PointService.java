package com.light.datadispose.service.point;

import com.baomidou.mybatisplus.extension.service.IService;
import com.light.datadispose.model.point.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointService extends IService<Point> {
    List<Point> findAllByDeptId(Integer deptId);
}
