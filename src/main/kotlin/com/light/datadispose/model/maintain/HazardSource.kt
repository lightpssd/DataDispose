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
@TableName("hazard_source")
class HazardSource : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var did: Int? = null

    var createUserId: Int? = null

    var deptName: String? = null

    var createUser: String? = null

    /**
     * 工序
     */
    var process: String? = null

    /**
     * 序号
     */
    var serialNo: String? = null

    /**
     * 危险源
     */
    var hazard: String? = null

    /**
     * 产生的风险
     */
    var risk: String? = null

    /**
     * 可能性
     */
    var possibility: String? = null

    /**
     * 频率
     */
    var frequency: String? = null

    /**
     * 严重性
     */
    var seriousness: String? = null

    /**
     * 对策
     */
    var countermeasure: String? = null

    /**
     * 改善后预计可能性
     */
    var impPoss: String? = null

    /**
     * 改善后预计频率
     */
    var impFre: String? = null

    /**
     * 改善后预计严重性
     */
    var impSerious: String? = null

    /**
     * 评价分
     */
    var score: String? = null

    /**
     * 风险等级
     */
    var riskLevel: String? = null

    /**
     * 改善后预计评价分
     */
    var impScore: String? = null

    /**
     * 改善后预计风险等级
     */
    var impRiskLevel: String? = null

    /**
     * 责任人
     */
    var personLiable: String? = null

    /**
     * 实施部门
     */
    var impDept: String? = null

    /**
     * 完成期限
     */
    var compTime: String? = null

    /**
     * 改善后可能性确认
     */
    var cfmPoss: String? = null

    /**
     * 改善后频率确认
     */
    var cfmFre: String? = null

    /**
     * 改善后严重性确认
     */
    var cfmSerious: String? = null

    /**
     * 改善后评价分确
     */
    var cfmScore: String? = null

    /**
     * 改善后风险等级确认
     */
    var cfmRiskLevel: String? = null

    /**
     * 确认人
     */
    var confirm: String? = null

    /**
     * 备注
     */
    var bz: String? = null

    override fun toString(): String {
        return "HazardSource{" +
        "id=" + id +
        ", did=" + did +
        ", createUserId=" + createUserId +
        ", deptName=" + deptName +
        ", createUser=" + createUser +
        ", process=" + process +
        ", serialNo=" + serialNo +
        ", hazard=" + hazard +
        ", risk=" + risk +
        ", possibility=" + possibility +
        ", frequency=" + frequency +
        ", seriousness=" + seriousness +
        ", countermeasure=" + countermeasure +
        ", impPoss=" + impPoss +
        ", impFre=" + impFre +
        ", impSerious=" + impSerious +
        ", score=" + score +
        ", riskLevel=" + riskLevel +
        ", impScore=" + impScore +
        ", impRiskLevel=" + impRiskLevel +
        ", personLiable=" + personLiable +
        ", impDept=" + impDept +
        ", compTime=" + compTime +
        ", cfmPoss=" + cfmPoss +
        ", cfmFre=" + cfmFre +
        ", cfmSerious=" + cfmSerious +
        ", cfmScore=" + cfmScore +
        ", cfmRiskLevel=" + cfmRiskLevel +
        ", confirm=" + confirm +
        ", bz=" + bz +
        "}"
    }
}
