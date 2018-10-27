package com.blue.dao;

import com.blue.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
public abstract class UserDao {
    public abstract List<User> findAll() throws SQLException;

    public abstract User findByID(String id) throws SQLException;

    public abstract List<User> findAll(int page, int var) throws SQLException;

    public abstract void addUser(User user)throws SQLException;

    public abstract void batch(List<User> users)throws SQLException;

    public abstract void delete(String id)throws SQLException;

    public abstract void update(User user)throws SQLException;
}
