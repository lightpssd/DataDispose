package com.light.datadispose.utils;

import com.light.datadispose.Exception.FunRunningException;

import java.util.Set;

public class FunRunningUtil {
    public static void FunIsRunning(Set<String> set,String fun){
        if (set.contains(fun))throw new FunRunningException();
    }
}
