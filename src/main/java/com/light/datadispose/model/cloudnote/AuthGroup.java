package com.light.datadispose.model.cloudnote;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("auth_group")
public class AuthGroup {
    private Integer id;
    private String name;
}
