package com.es.es_server4.service.impl;

import com.es.es_server4.model.dao.TestEs2Mapper;
import com.es.es_server4.model.pojo.TestEs2;
import com.es.es_server4.service.TestEs2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEs2Impl implements TestEs2Service {

    @Autowired
    TestEs2Mapper testEs2Mapper;

    @Override
    public TestEs2 getTestEs2() {
        return testEs2Mapper.selectByPrimaryKey("1");
    }
}
