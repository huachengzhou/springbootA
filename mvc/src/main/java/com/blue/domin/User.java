package com.blue.domin;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/6
 **/
public class User {
    private String id;
    private String name;
    private String userName;

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User(String id, String name, String userName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
    }

    public User() {
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
