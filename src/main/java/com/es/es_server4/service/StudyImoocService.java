package com.es.es_server4.service;

import com.es.es_server4.exception.ExceptionImooc;
import com.es.es_server4.model.pojo.TestEs2;

import java.security.NoSuchAlgorithmException;

public interface StudyImoocService {

    void register(String username, String password) throws ExceptionImooc, NoSuchAlgorithmException;

    //登录时，先将密码转为MD5,再去查找
    TestEs2 login(String username, String password) throws ExceptionImooc;

    void updateInformation(TestEs2 testEs2) throws ExceptionImooc;
}
