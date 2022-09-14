package com.light.datadispose.model;

public class MyResult {

    private StateCode code;
    private String msg;
    private Object data;

    public MyResult() {
    }

    public StateCode getCode() {
        return code;
    }

    public void setCode(StateCode code) {
        this.code = code;
    }

    public MyResult(StateCode code, String msg, Object data) {
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



    public static MyResult ok(){
        return new MyResult(StateCode.OK,null,null);
    }
    public static MyResult FunRunningError(){
        return new MyResult(StateCode.FUNRUNNING,"该功能正在运行中",null);
    }
    public static MyResult Error(){
        return new MyResult(StateCode.STANDARDERROR,"服务器忙碌",null);
    }
}
