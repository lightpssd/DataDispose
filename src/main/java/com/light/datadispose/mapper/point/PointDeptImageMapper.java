package com.light.datadispose.mapper.point;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.datadispose.model.point.PointDeptImage;
import org.apache.ibatis.annotations.Mapper;

@DS("point")
@Mapper
public interface PointDeptImageMapper extends BaseMapper<PointDeptImage> {
}
