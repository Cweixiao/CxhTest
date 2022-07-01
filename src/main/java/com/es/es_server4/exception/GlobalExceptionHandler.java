package com.es.es_server4.exception;


import com.es.es_server4.common.ApiRestResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Service层的业务异常，均抛到了controller层，接下来该需要处理这些异常，使其与APIresponese相同，做到统一返回
 */
@ControllerAdvice    //处理Controller层的异常
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理Exception类的异常,既系统异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception ex){
        log.error("Default Exception: ",ex);
        return ApiRestResponse.error(ExceptionEnum.SYSTEM_ERROR);
    }



    /**
     * 处理业务异常(所有业务异常，均在枚举里)
     */
    @ExceptionHandler(ExceptionImooc.class)
    @ResponseBody
    public Object handleException(ExceptionImooc ex){
        log.error("业务异常: ",ex);
        return ApiRestResponse.error(ex.getCode(),ex.getMsg());
    }







}
