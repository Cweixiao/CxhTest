package com.es.es_server4.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class WebLogAspect {
    private final Logger log = LoggerFactory.getLogger(WebLogAspect.class);


    //拦截点在controller下的所有
    @Pointcut("execution(public * com.es.es_server4.controller.*.*(..))")
    public void webLog(){

    }


    //请求时
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //在webLog函数前，做：记录收到的请求，
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL : " + request.getRequestURI().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : "+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());   //获取类信息
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));   //获得请求的参数数组，转化为字符串
    }


    //响应时
    @AfterReturning(returning = "res" , pointcut = "webLog()")      //pointcut为拦截点
    public void doAfterReturning(Object res) throws JsonProcessingException {
        //处理完请求返回内容

        log.info("RESPONSE : " + new ObjectMapper().writeValueAsString(res));    //new ObjectMapper().writeValueAsString(res) 将res转为json格式

    }
}
