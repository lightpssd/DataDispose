package com.light.datadispose.model.point;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;

/**
 * (PointInfo)实体类
 * @since 2022-09-08 16:36:17
 */

@TableName("point_info")
public class PointInfo implements Serializable {

    private static final long serialVersionUID = 209803534084800371L;

    @Override
    public String toString() {
        return "PointInfo{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", pointId='" + pointId + '\'' +
                '}';
    }

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("`key`")
    private String key;
    @TableField("`value`")
    private String value;
    
    private String pointId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

}

