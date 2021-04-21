package com.example.demo.exception;

import com.example.demo.util.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(LfgException.class)
    @ResponseBody
    public JsonData error(LfgException exception){
        log.error(exception.getMsg());
        exception.printStackTrace();
        return JsonData.error().code(exception.getCode()).msg(exception.getMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonData error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return JsonData.error();
    }
}
