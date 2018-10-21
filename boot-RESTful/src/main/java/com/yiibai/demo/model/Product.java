package com.yiibai.demo.model;

import java.io.Serializable;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/21
 **/
public class Product implements Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
