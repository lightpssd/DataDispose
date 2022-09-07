package com.light.datadispose.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Result {

    private StateCode code;
    private String msg;
    private Object data;

    public Result() {
    }

    public StateCode getCode() {
        return code;
    }

    public void setCode(StateCode code) {
        this.code = code;
    }

    public Result(StateCode code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public static Result ok(){
        return new Result(StateCode.OK,null,null);
    }
    public static Result FunRunningError(){
        return new Result(StateCode.FUNRUNNING,"该功能正在运行中",null);
    }
}
