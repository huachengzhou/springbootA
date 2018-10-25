package com.blue.dao;

import com.blue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/25
 **/
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;
}
