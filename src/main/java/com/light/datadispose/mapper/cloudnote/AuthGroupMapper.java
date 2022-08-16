package com.light.datadispose.mapper.cloudnote;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.datadispose.model.cloudnote.AuthGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("note")
public interface AuthGroupMapper extends BaseMapper<AuthGroup> {

}
