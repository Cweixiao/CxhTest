package com.es.es_server4.dao;

//访问数据的接口

import com.es.es_server4.model.javaTestIndex1;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

//数据访问对象，类似于连接数据库时的dao层
//告诉spring这是一个资源，可以被自动识别，
@Repository
public interface SgDao extends ElasticsearchRepository<javaTestIndex1, Integer> {

}
