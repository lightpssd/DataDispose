package com.light.datadispose.model.point;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("point_dept_image")
public class PointDeptImage {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer deptId;

    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "PointDeptImage{" +
                "id=" + id +
                ", deptID=" + deptId +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
