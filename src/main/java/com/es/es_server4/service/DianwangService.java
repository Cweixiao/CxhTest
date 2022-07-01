package com.es.es_server4.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


/**
 * service需要借助mapper
 */

public interface DianwangService {

    public void createIndex();


    public void deleteIndex();

    public void delete();

    public void save();

    public void batchSave();

    public void update();

    public void findById();

    public void findAll();

    public void findByPage();

    Map<String, Object> QueryByID(String index, String data) throws IOException;

    public Map<String, Object> termsQery(String index, String field, String data);

    public Map<String, Object> matchAll(String index,String feild);

    public Map<String, Object> multiMatchAll(String index,String field,String data);


}
