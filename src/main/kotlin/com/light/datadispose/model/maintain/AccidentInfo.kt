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
@TableName("accident_info")
data class AccidentInfo(@TableId(value = "id", type = IdType.AUTO)
                            var id: Int? = null,
                            var did: Int? = null,
                            var createUserId: Int? = null,
                            var deptName: String? = null,
                            var createUser: String? = null,
                            /**
                             * 发生时间
                             */
                            var occurDate: String? = null,
                            /**
                             * 发生地点
                             */
                            var occurAddress: String? = null,
                            /**
                             * 员工受伤情况
                             */
                            var empInjuries: String? = null,
                            /**
                             * 事故具体情况
                             */
                            var accidentDetails: String? = null,
                            /**
                             * 事故原因
                             */
                            var accidentCause: String? = null,
                            /**
                             * 图片地址
                             */
                            var photoPath: String? = null,
                            ) : Serializable {

    override fun toString(): String {
        return "AccidentInfo{" +
        "id=" + id +
        ", did=" + did +
        ", createUserId=" + createUserId +
        ", deptName=" + deptName +
        ", createUser=" + createUser +
        ", occurDate=" + occurDate +
        ", occurAddress=" + occurAddress +
        ", empInjuries=" + empInjuries +
        ", accidentDetails=" + accidentDetails +
        ", accidentCause=" + accidentCause +
        ", photoPath=" + photoPath +
        "}"
    }
}
