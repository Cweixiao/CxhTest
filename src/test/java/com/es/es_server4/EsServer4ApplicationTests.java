package com.es.es_server4;

import com.es.es_server4.config.ElasticsearchConfig;
import com.es.es_server4.dao.SgDao;
import com.es.es_server4.filter.WebLogAspect;
import com.es.es_server4.model.javaTestIndex1;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.AcknowledgedResponse;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.ScrollableHitSource;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RunAs;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class EsServer4ApplicationTests {
    private final Logger log = LoggerFactory.getLogger(WebLogAspect.class);


    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private SgDao sgDao;

    @Autowired
    private ElasticsearchConfig elasticsearchConfig;

    @Test
    void contextLoads() {
    }

    @Test
    public void createIndex() {
        System.out.println("创建成功");
    }

    @Test
    public void deleteIndex() {


//         该方法可以定位到准确的索引名
//        IndexCoordinates idx = IndexCoordinates.of("javatextindex1");
//        IndexOperations idxOps = elasticsearchRestTemplate.indexOps(idx);
//        boolean delete = idxOps.delete();

        //该方法自动根据实体类结构删除索引
        boolean delete = elasticsearchRestTemplate.indexOps(javaTestIndex1.class).delete();

        System.out.println("删除：" + delete);
    }

    @Test
    public void delete() {
        javaTestIndex1 javaTestIndex1 = new javaTestIndex1();
        javaTestIndex1.setId(1);
        sgDao.delete(javaTestIndex1);
    }


    //单个插入
    @Test
    public void save() {
        javaTestIndex1 javaTestIndex1 = new javaTestIndex1();
        javaTestIndex1.setId(10003);
        javaTestIndex1.setName("你是谁啊，我不认识你，你真是的");
        sgDao.save(javaTestIndex1);


    }


    //批量插入
    @Test
    public void batchSave() {
        ArrayList<javaTestIndex1> javaTestIndex1s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            javaTestIndex1 javaTestIndex1 = new javaTestIndex1();
            javaTestIndex1.setId(1001 + i);
            javaTestIndex1.setName("batchInsert" + javaTestIndex1.getId());
            javaTestIndex1s.add(javaTestIndex1);
        }
        sgDao.saveAll(javaTestIndex1s);


    }


    @Test
    public void update() {
        javaTestIndex1 javaTestIndex1 = new javaTestIndex1();
        javaTestIndex1.setId(1);
        javaTestIndex1.setName("程阿牛");
        sgDao.save(javaTestIndex1);
    }


    //根据Id查询
    @Test
    public void findById() {
        javaTestIndex1 javaTestIndex1 = sgDao.findById(10000).get();
        System.out.println(javaTestIndex1);
    }

    //查询所有
    @Test
    public void findAll() {
        Iterable<javaTestIndex1> javatestIndex1s = sgDao.findAll();
        for (javaTestIndex1 javaTestIndex1one : javatestIndex1s) {
            System.out.println(javaTestIndex1one);
        }
    }

    @Test
    public void findByPage() {
        //设置排序方式，倒叙还是正序
        Sort id = Sort.by(Sort.Direction.DESC, "id");
        int from = 0;
        int size = 5;

        //设置分页查询
        PageRequest of = PageRequest.of(from, size, id);
        Page<javaTestIndex1> all = sgDao.findAll(of);
        for (javaTestIndex1 javatestIndex1 : all.getContent()) {
            System.out.println(javatestIndex1);
        }
    }





    @Test
    public void termsQery() {
        //获取客户端
        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //获取我们需要的查询请求
        //创建一个指定索引的新search请求
        SearchRequest request = new SearchRequest("javatextindex1");
        //创建一个查询对象
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.from(0);
//        builder.size(1000);
        //将查询对象指定为terms查询
        builder.query(QueryBuilders.termsQuery("name", "java_test_name4","java_test_name3"));
        //将查询封装进请求中
        request.source(builder);



        //通过客户端发送请求
        //新建接受响应的response
        SearchResponse search = null;
        try {
            int i = 0;
            Map<String, Object> mapSum = new HashMap<>();
            List<Map> mapList = new ArrayList<>();
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

    }

    @Test
    public void matchAll(){
        RestHighLevelClient client = elasticsearchConfig.elasticsearchClient();


        //获取我们需要的查询请求
        //创建一个指定索引的新search请求
        SearchRequest request = new SearchRequest("v_fiber_seg_change");
        //创建一个查询对象
        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.from(0);
//        builder.size(1000);


        //match_all
//        builder.query(QueryBuilders.matchAllQuery());

        //match，模糊查询   and,将 你好 分词后，必须同时包含所有分词结果的查询
        builder.query(QueryBuilders.matchQuery("authority_unit_name","湖北省电力公司").operator(Operator.AND));

        //指定显示的数据数量
        builder.size(1000);
        //将查询封装进请求中
        request.source(builder);


        //通过客户端发送请求
        //新建接受响应的response
        SearchResponse search = null;
        try {
            int i = 0;
            Map<String, Object> mapSum = new HashMap<>();
            List<Map> mapList = new ArrayList<>();
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

    }


}
