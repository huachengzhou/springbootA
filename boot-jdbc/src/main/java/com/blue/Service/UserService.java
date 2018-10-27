package com.blue.Service;

import com.blue.entity.User;

import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
public interface UserService {

    public abstract List<User> findAll() throws Exception;

    public abstract User findByID(String id) throws Exception;

    public abstract List<User> findAll(int page, int var) throws Exception;

    public abstract void addUser(User user)throws Exception;

    public abstract void batch(List<User> users)throws Exception;

    public abstract void delete(String id)throws Exception;

    public abstract void update(User user)throws Exception;
}
