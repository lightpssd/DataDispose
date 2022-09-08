package com.light.datadispose.model.point;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * (Point)实体类
 *
 * @author makejava
 * @since 2022-09-08 16:36:15
 */
@TableName("point")
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = -49821408112579544L;

    @TableId
    private String id;
    /**
     * x轴
     */
    private Integer axis;
    /**
     * y轴
     */
    private Integer ayis;
    /**
     * 宽
     */
    private Integer width;
    /**
     * 高
     */
    private Integer height;
    
    private Integer isround;
    
    private String showImage;
    
    private String iconImage;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    private List<Point> points;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAxis() {
        return axis;
    }

    public void setAxis(Integer axis) {
        this.axis = axis;
    }

    public Integer getAyis() {
        return ayis;
    }

    public void setAyis(Integer ayis) {
        this.ayis = ayis;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getIsround() {
        return isround;
    }

    public void setIsround(Integer isround) {
        this.isround = isround;
    }

    public String getShowImage() {
        return showImage;
    }

    public void setShowImage(String showImage) {
        this.showImage = showImage;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

}

