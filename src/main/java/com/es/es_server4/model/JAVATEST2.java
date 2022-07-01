package com.es.es_server4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "javatest2",shards = 5,replicas = 1)
public class JAVATEST2 {

    @Id
    private Integer id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "javatest2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
