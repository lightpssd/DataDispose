package com.light.datadispose.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private StateCode code;
    private String msg;
    private Object data;
    public static Result ok(){
        return new Result(StateCode.OK,null,null);
    }
    public static Result FunRunningError(){
        return new Result(StateCode.FUNRUNNING,"该功能正在运行中",null);
    }
}
