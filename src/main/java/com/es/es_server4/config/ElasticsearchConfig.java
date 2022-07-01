package com.es.es_server4.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;



@ConfigurationProperties(prefix = "elasticsearch") //在配置文件中找到elasticsearch为前缀的配置，读取到host和port中
@Configuration
@Data
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    private String host;
    private Integer port;




    //获取客户端
    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder builder= RestClient.builder(new HttpHost(host,port));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

        return restHighLevelClient;
    }


}
