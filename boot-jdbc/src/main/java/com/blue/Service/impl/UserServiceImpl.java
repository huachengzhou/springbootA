package com.blue.Service.impl;

import com.blue.Service.UserService;
import com.blue.dao.UserDao;
import com.blue.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public User findByID(String id) throws Exception {
        return userDao.findByID(id);
    }

    @Override
    public List<User> findAll(int page, int var) throws Exception {
        return userDao.findAll(page, var);
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public void batch(List<User> users) throws Exception {
        userDao.batch(users);
    }

    @Override
    public void delete(String id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public void update(User user) throws Exception {
        userDao.update(user);
    }
}
