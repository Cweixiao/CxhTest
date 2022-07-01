package com.es.es_server4.dao;

import com.es.es_server4.model.TEqpModule;

public interface TEqpModuleMapper {
    /**
     * delete by primary key
     * @param objId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String objId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TEqpModule record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TEqpModule record);

    /**
     * select by primary key
     * @param objId primary key
     * @return object by primary key
     */
    TEqpModule selectByPrimaryKey(String objId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TEqpModule record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TEqpModule record);
}