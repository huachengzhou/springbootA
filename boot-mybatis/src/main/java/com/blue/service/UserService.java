package com.blue.service;

import com.blue.dao.UserDao;
import com.blue.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/27
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getByUserId(Integer userId)throws Exception{
        return userDao.getByUserId(userId);
    }

    public boolean saveAndUpdate(User user)throws Exception{
        return userDao.saveAndUpdate(user);
    }

    public boolean deleteByPrimaryKey(Integer id)throws Exception{
        return userDao.deleteByPrimaryKey(id);
    }
}
