package com.es.es_server4.exception;


/**
 * 常见异常的枚举，用于方便开发
 */
public enum ExceptionEnum {

    /**
     * 该枚举类的实例
     */
    /**
     * 业务异常
     */
    NEED_DATA(10001,"需要传递查询参数"),
    NEED_USER_NAME(10002,"请输入用户名"),
    NEED_PASSWORD(10003,"请输入密码"),
    PASSWORD_LENGTH(10004,"密码长度为8至16位"),
    USERNAME_EXISTED(10005,"该用户名已存在"),
    PASSWORD_WRONG(10006,"密码错误"),
    NEED_LOGIN(10007,"请登录"),
    UPDATE_WRONG(10008,"更新失败"),
    INSERT_FAILED(10009,"数据库插入失败"),


    /**
     * 系统异常
     */
    SYSTEM_ERROR(20000,"系统异常");



    /**
     * 异常码和异常信息
     */
    Integer code;
    String msg;

    /**
     * 构造函数，枚举类的构造不需要加限定符，因为只有该类内可以使用
     * @param code
     * @param msg
     */
    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
