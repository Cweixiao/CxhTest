package com.es.es_server4.service.impl;

import com.es.es_server4.config.ElasticsearchConfig;
import com.es.es_server4.dao.SgDao;
import com.es.es_server4.service.DianwangService;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DianwangImpl implements DianwangService {
    private final Logger log = LoggerFactory.getLogger(DianwangImpl.class);

//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private SgDao sgDao;

    @Autowired
    private ElasticsearchConfig elasticsearchConfig;



    @Override
    public void createIndex() {

    }

    @Override
    public void deleteIndex() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void save() {

    }

    @Override
    public void batchSave() {

    }

    @Override
    public void update() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findByPage() {

    }

    @Override
    public Map<String, Object> QueryByID(String index, String data) throws IOException {
        Map<String, Object> mapSum = new HashMap<>();

        //获取客户端
        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //1.创建GetRequest
        GetRequest getRequest = new GetRequest(index,data);

        //2.执行查询
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);


        List<Map> mapList = new ArrayList<>();
        mapList.add(response.getSourceAsMap());
        if(response.getSourceAsMap() == null){
            mapSum.put("total",0);
        }else{
            mapSum.put("total",1);
        }
        mapSum.put("mapList",mapList);
        log.info(mapSum.toString());

        return mapSum;
    }


    @Override
    public Map<String, Object> termsQery(String index,String field,String data) {

        //获取客户端
        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //获取我们需要的查询请求
        //创建一个指定索引的新search请求
        SearchRequest request = new SearchRequest(index);
        //创建一个查询对象
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.from(0);
//        builder.size(1000);
        //将查询对象指定为terms查询
        builder.query(QueryBuilders.termsQuery(field, data));
        //将查询封装进请求中
        request.source(builder);



        //通过客户端发送请求
        //新建接受响应的response
        SearchResponse search = null;
        Map<String, Object> mapSum = new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        try {
            int i = 0;

            search = client.search(request, RequestOptions.DEFAULT);
            //解析除了json中的hits，既有效数据部分
            SearchHit[] hits = search.getHits().getHits();
            for (SearchHit searchHit : hits) {
                Map<String, Object> map = searchHit.getSourceAsMap();
                i++;
                mapList.add(map);
            }
            mapSum.put("total",i);
            mapSum.put("mapList",mapList);
            log.info(mapSum.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //该种返回的是kibana中的原版json格式
//        search.getHits().forEach(System.out::println);
        return mapSum;

    }



    //参数为 "" 则查询所有的数据
    @Override
    public Map<String, Object> matchAll( String index,String feild) {
        Map<String, Object> mapFeild = null; // 用于存储条件筛选的字段

        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //获取我们需要的查询请求
        //创建一个指定索引的新search请求
        SearchRequest request = new SearchRequest(index);
        //创建一个查询对象
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.from(0);

        //显示数据的数量，默认为10
        builder.size(100000);


        //match_all
        builder.query(QueryBuilders.matchAllQuery());

        //match，模糊查询   and,将 你好 分词后，必须同时包含所有分词结果的查询
//        builder.query(QueryBuilders.matchQuery("authority_unit_name", "湖北省电力公司").operator(Operator.AND));

        //指定显示的数据数量
        builder.size(1000);
        //将查询封装进请求中
        request.source(builder);


        //通过客户端发送请求
        //新建接受响应的response
        SearchResponse search = null;
        Map<String, Object> mapSum = new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        try {
            int i = 0;

            search = client.search(request, RequestOptions.DEFAULT);
            //解析除了json中的hits，既有效数据部分
            SearchHit[] hits = search.getHits().getHits();
            for (SearchHit searchHit : hits) {
                Map<String, Object> map = searchHit.getSourceAsMap();

                if(feild != ""){
                    mapFeild = new HashMap<>();
                    mapFeild.put("Id",map.get("obj_id"));
                    mapFeild.put("Name",map.get(feild));
                }

                i++;
                if(mapFeild != null){
                    mapList.add(mapFeild);
                }else{
                    mapList.add(map);
                }

            }
            mapSum.put("total",i);
            mapSum.put("mapList",mapList);
            log.info(mapSum.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //该种返回的是kibana中的原版json格式
//        search.getHits().forEach(System.out::println);
        return mapSum;


    }

    @Override
    public Map<String, Object> multiMatchAll(String index,String field,String data) {


        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //获取我们需要的查询请求
        //创建一个指定索引的新search请求
//        SearchRequest request = new SearchRequest("v_fiber_seg_change");
        SearchRequest request = new SearchRequest(index);
        //创建一个查询对象
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.from(0);
//        builder.size(1000);


        //match_all
//        builder.query(QueryBuilders.matchAllQuery());

        //match，模糊查询   and,将 你好 分词后，必须同时包含所有分词结果的查询
//        builder.query(QueryBuilders.multiMatchQuery("河南省电力公司","authority_unit_name","maintenance_dept_name"));
        builder.query(QueryBuilders.multiMatchQuery(data,field));

        //指定显示的数据数量
//        builder.size(1000);
        //将查询封装进请求中
        request.source(builder);


        //通过客户端发送请求
        //新建接受响应的response
        SearchResponse search = null;
        Map<String, Object> mapSum = new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        try {
            int i = 0;

            search = client.search(request, RequestOptions.DEFAULT);
            //解析除了json中的hits，既有效数据部分
            SearchHit[] hits = search.getHits().getHits();
            for (SearchHit searchHit : hits) {
                Map<String, Object> map = searchHit.getSourceAsMap();
                i++;
                mapList.add(map);
            }

            mapSum.put("mapList",mapList);  //插入map列表
            mapSum.put("total",i);          //插入map总量

            log.info(mapSum.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //该种返回的是kibana中的原版json格式
//        search.getHits().forEach(System.out::println);
        return mapSum;


    }




}
