package com.light.datadispose.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StateCode {
    OK(20000),
    FUNRUNNING(30001)
    ;

    @JsonValue
    public final Integer code;
    StateCode(int i) {
        this.code=i;
    }

}
