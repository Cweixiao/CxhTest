package com.es.es_server4.model.dao;

import com.es.es_server4.model.pojo.FiberSegChange;

public interface FiberSegChangeMapper {
    int insert(FiberSegChange record);

    int insertSelective(FiberSegChange record);
}