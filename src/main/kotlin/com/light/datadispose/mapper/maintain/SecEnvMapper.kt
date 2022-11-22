package com.light.datadispose.mapper.maintain
import com.baomidou.dynamic.datasource.annotation.DS
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.light.datadispose.model.maintain.SecEnv
import org.apache.ibatis.annotations.Mapper

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author light
 * @since 2022-11-22
 */
@Mapper
@DS("maintain")
interface SecEnvMapper : BaseMapper<SecEnv>
