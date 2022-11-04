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
@TableName("history_example")
class HistoryExample : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var did: Int? = null

    var createUserId: Int? = null

    var deptName: String? = null

    var createUser: String? = null

    /**
     * 不良项目
     */
    var badProject: String? = null

    /**
     * 不良区分
     */
    var badDist: String? = null

    /**
     * 品名
     */
    var proName: String? = null

    /**
     * 环别
     */
    var ringCategory: String? = null

    /**
     * 工序
     */
    var process: String? = null

    /**
     * 作业要领书
     */
    var operationStandard: String? = null

    /**
     * 管理
     */
    var manage: String? = null

    /**
     * 反馈日期
     */
    var feedbackDate: String? = null

    /**
     * 反馈场所
     */
    var feedbackAddress: String? = null

    /**
     * 不良内容
     */
    var badContent: String? = null

    /**
     * 发生片数
     */
    var sliceCount: String? = null

    /**
     * 不良状况
     */
    var badStatus: String? = null

    /**
     * 要因解析
     */
    var causeAnalysis: String? = null

    /**
     * 对策
     */
    var countermeasure: String? = null

    /**
     * 图片
     */
    var photoPath:String?=null

    override fun toString(): String {
        return "HistoryExample{" +
        "id=" + id +
        ", did=" + did +
        ", createUserId=" + createUserId +
        ", deptName=" + deptName +
        ", createUser=" + createUser +
        ", badProject=" + badProject +
        ", badDist=" + badDist +
        ", proName=" + proName +
        ", ringCategory=" + ringCategory +
        ", process=" + process +
        ", operationStandard=" + operationStandard +
        ", manage=" + manage +
        ", feedbackDate=" + feedbackDate +
        ", feedbackAddress=" + feedbackAddress +
        ", badContent=" + badContent +
        ", sliceCount=" + sliceCount +
        ", badStatus=" + badStatus +
        ", causeAnalysis=" + causeAnalysis +
        ", countermeasure=" + countermeasure +
        "}"
    }
}
