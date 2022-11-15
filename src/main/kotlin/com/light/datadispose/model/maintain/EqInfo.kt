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
 * @since 2022-11-14
 */
@TableName("eq_info")
class EqInfo : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var did: Int? = null

    var createUserId: Int? = null

    var deptName: String? = null

    var createUser: String? = null

    /**
     * 设备编号
     */
    var eqCode: String? = null

    /**
     * 设备名称
     */
    var eqName: String? = null

    /**
     * 规格型号
     */
    var model: String? = null

    /**
     * 现状
     */
    var presentSituation: String? = null

    /**
     * 厂家
     */
    var manufactor: String? = null

    /**
     * 日期
     */
    var date: String? = null

    /**
     * 存放地点
     */
    var address: String? = null

    /**
     * 盘点结果
     */
    var invRes: String? = null

    /**
     * 是否处理
     */
    var handle: String? = null

    /**
     * 处理结果
     */
    var hanRes: String? = null

    /**
     * 备注
     */
    var bz: String? = null

    override fun toString(): String {
        return "EqInfo{" +
        "id=" + id +
        ", did=" + did +
        ", createUserId=" + createUserId +
        ", deptName=" + deptName +
        ", createUser=" + createUser +
        ", eqCode=" + eqCode +
        ", eqName=" + eqName +
        ", model=" + model +
        ", presentSituation=" + presentSituation +
        ", manufactor=" + manufactor +
        ", date=" + date +
        ", address=" + address +
        ", invRes=" + invRes +
        ", handle=" + handle +
        ", hanRes=" + hanRes +
        ", bz=" + bz +
        "}"
    }
}
