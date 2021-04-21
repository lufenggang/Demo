package com.example.demo.exception;

import lombok.Data;

@Data
public class LfgException extends RuntimeException {
    private static final long serialVersionUID = -5685667617295814047L;

    private Integer code;

    private String msg;

    public LfgException(){

    }

    public LfgException(Integer code , String msg){
        this.code = code;
        this.msg =  msg;
    }
}
