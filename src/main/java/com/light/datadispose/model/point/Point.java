package com.light.datadispose.model.point;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

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



    private Boolean isRound;

    private Boolean outerBorder;
    private String outerBorderColor;
    private Boolean lightStyle;

    private Boolean tipActive;
    private String tipText;

    private String deviceInformationId;

    private String hazardSourceId;

    private Integer fontSize;
    private String fontColor;
    private String fontFamily;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getDeviceInformationId(){
        return deviceInformationId;
    }

    public void setDeviceInformationId(String deviceInformationId){
        this.deviceInformationId = deviceInformationId;
    }

    public String getHazardSourceId() {
        return hazardSourceId;
    }

    public void setHazardSourceId(String hazardSourceId) {
        this.hazardSourceId = hazardSourceId;
    }

    public Boolean getOuterBorder() {
        return outerBorder;
    }

    public void setOuterBorder(Boolean outerBorder) {
        this.outerBorder = outerBorder;
    }

    public String getOuterBorderColor() {
        return outerBorderColor;
    }

    public void setOuterBorderColor(String outerBorderColor) {
        this.outerBorderColor = outerBorderColor;
    }

    public Boolean getLightStyle() {
        return lightStyle;
    }

    public void setLightStyle(Boolean lightStyle) {
        this.lightStyle = lightStyle;
    }

    public Boolean getTipActive() {
        return tipActive;
    }

    public void setTipActive(Boolean tipActive) {
        this.tipActive = tipActive;
    }

    public String getTipText() {
        return tipText;
    }

    public void setTipText(String tipText) {
        this.tipText = tipText;
    }




    @JsonProperty("show_image")
    private String showImage;

    @JsonProperty("icon_image")
    private String iconImage;

    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", axis=" + axis +
                ", ayis=" + ayis +
                ", width=" + width +
                ", height=" + height +
                ", isRound=" + isRound +
                ", showImage='" + showImage + '\'' +
                ", iconImage='" + iconImage + '\'' +
                ", type=" + type +
                ", deptId=" + deptId +
                ", points=" + points +
                '}';
    }
    
    private String type;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    private Integer deptId;


    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    private String employeeNo;

    public String getOnPostPerson() {
        return onPostPerson;
    }

    public void setOnPostPerson(String onPostPerson) {
        this.onPostPerson = onPostPerson;
    }

    private String onPostPerson;
    private String dangerousInformation;
    private String changePointId;


    public String getHistoricalPointId() {
        return historicalPointId;
    }

    public void setHistoricalPointId(String historicalPointId) {
        this.historicalPointId = historicalPointId;
    }

    private String historicalPointId;

    public String getChangePointId() {
        return changePointId;
    }

    public void setChangePointId(String changePointId) {
        this.changePointId = changePointId;
    }

    public String getDangerousInformation() {
        return dangerousInformation;
    }

    public void setDangerousInformation(String dangerousInformation) {
        this.dangerousInformation = dangerousInformation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PointInfo> getPoints() {
        return points;
    }

    public void setPoints(List<PointInfo> points) {
        this.points = points;
    }

    @TableField(exist = false)
    private List<PointInfo> points;

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

    public Boolean getIsRound() {
        return isRound;
    }

    public void setIsRound(Boolean isRound) {
        this.isRound = isRound;
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

