package com.es.es_server4.controller;

import com.es.es_server4.common.ApiRestResponse;
import com.es.es_server4.common.Constant;
import com.es.es_server4.exception.ExceptionImooc;
import com.es.es_server4.exception.ExceptionEnum;
import com.es.es_server4.model.pojo.TestEs2;
import com.es.es_server4.service.StudyImoocService;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.SHA;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class StudyImoocController {
    @Autowired
    StudyImoocService studyImoocService;


    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestParam("username") String username,@RequestParam("password") String password) throws ExceptionImooc, NoSuchAlgorithmException {


        if(StringUtils.isEmpty(username)){
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if(StringUtils.isEmpty(password)){
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }
        if(password.length() < 8 || password.length() > 16){
            return ApiRestResponse.error(ExceptionEnum.PASSWORD_LENGTH);
        }

        /**
         * 经过了三重筛选，没问题了，则进行数据插入
         */
        studyImoocService.register(username,password);
        return ApiRestResponse.success();


    }


    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws ExceptionImooc {

        if(StringUtils.isEmpty(username)){
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if(StringUtils.isEmpty(password)){
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }

        TestEs2 testEs2 = studyImoocService.login(username, password);

        //为了安全，将返回的数据的密码，设置为空,防止他人抓取MD5密码，
        testEs2.setName(null);
        //将对象放进session中，防止登录时需要反复登录
        session.setAttribute(Constant.IMOOC_USER,testEs2);
        return ApiRestResponse.success(testEs2);
    }


    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse update(@RequestParam("data") String data, HttpSession session) throws ExceptionImooc {


        //将session中的对象进行获取
        TestEs2 CurrenttestEs2 = (TestEs2) session.getAttribute(Constant.IMOOC_USER);

        if(CurrenttestEs2 == null){
            return  ApiRestResponse.error(ExceptionEnum.NEED_LOGIN);
        }

        TestEs2 testEs2 = new TestEs2();
        testEs2.setId(CurrenttestEs2.getId());
        testEs2.setIsDeleted(Short.parseShort(data));

        studyImoocService.updateInformation(testEs2);
        return ApiRestResponse.success();

    }


    @GetMapping("/logout")
    @ResponseBody
    public ApiRestResponse logout(HttpSession session){
        session.removeAttribute(Constant.IMOOC_USER);
        return ApiRestResponse.success();
    }


}
