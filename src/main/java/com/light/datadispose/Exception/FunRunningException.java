package com.light.datadispose.Exception;

public class FunRunningException extends RuntimeException{
    public FunRunningException(){
        super("该任务正在运行中，不能再次运行该任务");
    }
    public FunRunningException(String mes){
        super(mes);
    }
}
