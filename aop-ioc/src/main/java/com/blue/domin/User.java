package com.blue.domin;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 CREATE TABLE `spring-mvc-user` (
 `id` varchar(50) NOT NULL,
 `name` varchar(255) DEFAULT NULL,
 `username` varchar(255) DEFAULT NULL,
 `birthday` timestamp NULL DEFAULT NULL,
 `address` varchar(255) DEFAULT NULL,
 `account` varchar(255) DEFAULT NULL,
 `group` varchar(255) DEFAULT NULL,
 `sex` varchar(255) DEFAULT NULL,
 `jurisdiction` varchar(255) DEFAULT NULL,
 `permission` varchar(255) DEFAULT NULL,
 `role` varchar(255) DEFAULT NULL,
 `age` int(30) DEFAULT NULL,
 `password` varchar(255) DEFAULT NULL,
 PRIMARY KEY (`id`) USING BTREE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable, Comparable<User> {
    //id,name,username,password,birthday,address,account,`group`,sex,jurisdiction,permission,role,age
    private String id;
    private String name;
    private String username;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    private String account;
    private String permission;
    private String group;
    private String sex;
    private String jurisdiction;
    private String role;
    private int age;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPermission() {
        return permission;
    }

    public User setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public User setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public User setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User() {
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", permission='" + permission + '\'' +
                ", group='" + group + '\'' +
                ", sex='" + sex + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.getUsername().compareTo(o.getUsername());
    }
}
