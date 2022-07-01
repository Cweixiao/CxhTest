package com.es.es_server4.model.dao;

import com.es.es_server4.model.pojo.SpcSiteChange;

public interface SpcSiteChangeMapper {
    int insert(SpcSiteChange record);

    int insertSelective(SpcSiteChange record);
}