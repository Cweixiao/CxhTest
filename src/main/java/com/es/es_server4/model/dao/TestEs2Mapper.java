package com.es.es_server4.model.dao;

import com.es.es_server4.model.pojo.TestEs2;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TestEs2Mapper {
    int deleteByPrimaryKey(String id);

    int insert(TestEs2 record);

    int insertSelective(TestEs2 record);

    TestEs2 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestEs2 record);

    int updateByPrimaryKey(TestEs2 record);

    TestEs2 selectLogin(@Param("username") String username,@Param("password") String password);
}