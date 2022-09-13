package com.light.datadispose.mapper.point;
import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.datadispose.model.point.Point;
import org.apache.ibatis.annotations.Mapper;

@DS("point")
@Mapper
public interface PointMapper extends BaseMapper<Point> {

    List<Point> findAllByDeptId(@Param("deptId") Integer deptId);
}
