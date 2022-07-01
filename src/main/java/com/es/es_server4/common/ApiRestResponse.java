package com.es.es_server4.common;


import com.es.es_server4.exception.ExceptionEnum;

/**
 * 通用返回对象，例如成功返回success，，，
 */
public class ApiRestResponse<T> {

    //状态码
    private Integer status;
    //信息
    private String msg;
    //泛型对象
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //正常情况下的状态码和信息
    private static final int OK_CODE = 10000;
    private static final String OK_MSG = "SUCCESS";


    public ApiRestResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    //通常情况下，不会传递参数，因此可以用无参构造
    public ApiRestResponse() {
        //当调用无参构构造时，意味着正常，因此可以调用2参构造，返回正常代码
        this(OK_CODE,OK_MSG);
    }



    public static <T> ApiRestResponse<T> success(){
        return new ApiRestResponse<>();    //既返回一个通过无参形成的对象（携带成功信息）
    }

    public static <T> ApiRestResponse<T> success(T result){
        ApiRestResponse<T> response = new ApiRestResponse<>();   //携带成功信息
        response.setData(result);
        return response;
    }



    /**
     * 发生错误时，最好将常见的错误都一一枚举出来，用到时则可以通过统一返回的方式将这些异常返回
     * @param ex 枚举类内部的枚举实例
     * @param <T>
     * @return
     */
    public static <T> ApiRestResponse<T> error(ExceptionEnum ex){
        return new ApiRestResponse<>(ex.getCode(),ex.getMsg());
    }

    public static <T> ApiRestResponse<T> error(Integer code,String msg){
        return new ApiRestResponse<>(code,msg);
    }



}
