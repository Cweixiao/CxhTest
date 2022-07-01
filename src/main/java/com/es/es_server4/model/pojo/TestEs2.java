package com.es.es_server4.model.pojo;

public class TestEs2 {
    private String id;

    private String name;

    private Short isDeleted;

    public TestEs2(String id, String name, Short isDeleted) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public TestEs2() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }
}