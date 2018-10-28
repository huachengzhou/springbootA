package com.blue.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
public class User implements Serializable {

    public static class FinalFiled {
        public final static String ID = "id";
        public final static String CREATE = "create";
        public final static String NAME = "name";
        public final static String USERNAME = "username";
        public final static String PASSWORD = "password";
        public final static String BIRTHDAY = "birthday";
        public final static String ADDRESS = "address";
        public final static String ACCOUNT = "account";
        public final static String PERMISSION = "permission";
        public final static String GROUP = "group";
        public final static String SEX = "sex";
        public final static String JURISDICTION = "jurisdiction";
        public final static String ROLE = "role";
        public final static String AGE = "age";
        public final static String CREATEDATE = "createDate";
    }
    private String id;
    private String create;
    private String name;
    private String username;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date birthday;
    private String address;
    private String account;
    private String permission;
    private String group;
    private String sex;
    private String jurisdiction;
    private String role;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", create='" + create + '\'' +
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
                ", createDate=" + createDate +
                '}';
    }

}
