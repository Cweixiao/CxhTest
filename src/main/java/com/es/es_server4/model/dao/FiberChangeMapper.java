package com.es.es_server4.model.dao;

import com.es.es_server4.model.pojo.FiberChange;

public interface FiberChangeMapper {
    int insert(FiberChange record);

    int insertSelective(FiberChange record);
}