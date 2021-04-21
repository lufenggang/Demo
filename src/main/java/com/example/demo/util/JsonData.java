package com.example.demo.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class JsonData {
    private Integer code;

    private boolean success;

    private String msg;

    private Map<String,Object>  data = new HashMap<>();

    public JsonData() {

    }

    public JsonData(Integer code, boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    //成功响应
    public static JsonData success(){
        return new JsonData(20000,true,"成功");
    }

    //失败响应
    public static JsonData error(){
        return new JsonData(20001,false,"失败");
    }

    public JsonData success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public JsonData msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public JsonData code(Integer code){
        this.setCode(code);
        return this;
    }

    public JsonData data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public JsonData data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
