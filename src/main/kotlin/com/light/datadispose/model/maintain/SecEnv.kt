package com.light.datadispose.model.maintain

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

/**
 * <p>
 * 
 * </p>
 *
 * @author light
 * @since 2022-11-22
 */
@TableName("sec_env")
class SecEnv : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var did: Int? = null

    var createUserId: Int? = null

    /**
     * 危险源名称
     */
    var hazardName: String? = null

    /**
     * 管理责任部门
     */
    var manResDept: String? = null

    /**
     * 危险源因素分析表
     */
    var riskFactorPdf: String? = null

    /**
     * 实景照片
     */
    var realPhoto: String? = null

    /**
     * 应急预案
     */
    var contPlanPdf: String? = null

    /**
     * 应急演练报告
     */
    var drillReportPdf: String? = null

    /**
     * PM点检表
     */
    var spotCheckPdf: String? = null

    var deptName: String? = null

    var createUser: String? = null

    var uploadDate: String? = null

    override fun toString(): String {
        return "SecEnv{" +
        "id=" + id +
        ", did=" + did +
        ", createUserId=" + createUserId +
        ", hazardName=" + hazardName +
        ", manResDept=" + manResDept +
        ", riskFactorPdf=" + riskFactorPdf +
        ", realPhoto=" + realPhoto +
        ", contPlanPdf=" + contPlanPdf +
        ", drillReportPdf=" + drillReportPdf +
        ", spotCheckPdf=" + spotCheckPdf +
        ", deptName=" + deptName +
        ", createUser=" + createUser +
        ", uploadDate=" + uploadDate +
        "}"
    }
}
