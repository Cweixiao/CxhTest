package com.es.es_server4.service.impl;


import com.es.es_server4.exception.ExceptionImooc;
import com.es.es_server4.exception.ExceptionEnum;
import com.es.es_server4.model.dao.TestEs2Mapper;
import com.es.es_server4.model.pojo.TestEs2;
import com.es.es_server4.service.StudyImoocService;
import com.es.es_server4.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class StudyImoocImpl implements StudyImoocService {
    @Autowired
    TestEs2Mapper testEs2Mapper;

    @Override
    public void register(String username, String password) throws ExceptionImooc, NoSuchAlgorithmException {

        /**判断用户是否存在(通过修改mapper ,mapperx.xml进行对数据库查询)
         * 不存在则插入数据库，
         * 如果存在的话，由于处于Service层，不应该直接返回错误代码(那是Controller层的任务)，因此可以通过抛出异常的方式，将错误抛给Controller层
         * 因此为了像 统一返回对象那样，应将异常的返回进行同意，既throw的异常也是throw自己封装好的异常枚举类
         * //此处用TestEs2类作为演示
         */
        TestEs2 result = testEs2Mapper.selectByPrimaryKey(username);
        System.out.println(result);
        if (result != null) {
            throw new ExceptionImooc(ExceptionEnum.USERNAME_EXISTED);
        }

        /**
         * 通过了检测后，就可以将用户名密码进行保存了
         * 新建一个TestEs2对象，将值赋进去，然后通过mapper的insert函数（参数设置为TestEs2类）即可
         *
         * 通过判断插入函数的返回值，判断插入是否成功，若失败，则与上相同，抛出一个插入失败的枚举异常
         */
        TestEs2 testEs2 = new TestEs2();
        Short a = 1;
        testEs2.setId(username);
        testEs2.setName(MD5Util.getMD5Str(password));    //进行MD5加密处理
        testEs2.setIsDeleted(a);
        int insertSelective = testEs2Mapper.insertSelective(testEs2);
        if (insertSelective == 0) {
            throw new ExceptionImooc(ExceptionEnum.INSERT_FAILED);
        }


    }



    //登录时，先将密码转为MD5,再去查找
    @Override
    public TestEs2 login(String username, String password) throws ExceptionImooc {
        String md5Password = null;
        try {
            md5Password = MD5Util.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        TestEs2 testEs2 = testEs2Mapper.selectLogin(username, md5Password);
        if(testEs2 == null){
            throw new ExceptionImooc(ExceptionEnum.PASSWORD_WRONG);
        }
        return testEs2;

    }

    @Override
    public void updateInformation(TestEs2 testEs2) throws ExceptionImooc {
        //更新
        int i = testEs2Mapper.updateByPrimaryKeySelective(testEs2);
        if(i > 1){
            throw new ExceptionImooc(ExceptionEnum.UPDATE_WRONG);
        }


    }

}
