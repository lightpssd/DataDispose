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
 * @since 2022-10-22
 */
@TableName("change_point")
class ChangePoint : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var did: Int? = null

    var deptName: String? = null

    var createUserId: Int? = null

    var createUser: String? = null

    /**
     * 日期
     */
    var changeDate: String? = null

    /**
     * 工序
     */
    var process: String? = null

    /**
     * 人员姓名
     */
    var name: String? = null

    /**
     * 变化点说明
     */
    var changeState: String? = null

    /**
     * 潜在风险
     */
    var potentialRisk: String? = null

    /**
     * 管控方案
     */
    var controlScheme: String? = null

    /**
     * 责任人
     */
    var personLiable: String? = null

    /**
     * 完成期限
     */
    var compTime: String? = null

    /**
     * 品质确认及管控实施情况
     */
    var implementation: String? = null

    /**
     * 确认人
     */
    var confirmPerson: String? = null

    /**
     * 确认时间
     */
    var confirmTime: String? = null

    override fun toString(): String {
        return "ChangePoint{" +
        "id=" + id +
        ", did=" + did +
        ", deptName=" + deptName +
        ", createUserId=" + createUserId +
        ", createUser=" + createUser +
        ", changeDate=" + changeDate +
        ", process=" + process +
        ", name=" + name +
        ", changeState=" + changeState +
        ", potentialRisk=" + potentialRisk +
        ", controlScheme=" + controlScheme +
        ", personLiable=" + personLiable +
        ", compTime=" + compTime +
        ", implementation=" + implementation +
        ", confirmPerson=" + confirmPerson +
        ", confirmTime=" + confirmTime +
        "}"
    }
}
