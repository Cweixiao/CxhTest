package com.es.es_server4.model.dao;

import com.es.es_server4.model.pojo.NeSdhOthChange;

public interface NeSdhOthChangeMapper {
    int insert(NeSdhOthChange record);

    int insertSelective(NeSdhOthChange record);
}