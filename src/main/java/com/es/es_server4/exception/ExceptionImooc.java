package com.es.es_server4.exception;


/**
 * 统一业务异常(通过调用异常枚举中的业务异常)，用于区分业务和系统异常
 */
public class ExceptionImooc extends RuntimeException{

    private final Integer code;
    private final String msg;

    public ExceptionImooc(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    //调用时，则调用该函数，传入自己定义好的枚举异常
    public ExceptionImooc(ExceptionEnum ex){
        this(ex.getCode(),ex.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
