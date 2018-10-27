package com.blue.dao;

import com.blue.entity.User;
import com.blue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/25
 **/
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User getByUserId(Integer userId)throws SQLException{
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean saveAndUpdate(User user)throws SQLException{
        if (user.getUserId() == null || user.getUserId().intValue()==0){
            return userMapper.insertSelective(user)==1;
        }else {
            return userMapper.updateByPrimaryKeySelective(user)==1;
        }
    }

    public boolean deleteByPrimaryKey(Integer id)throws SQLException{
        return userMapper.deleteByPrimaryKey(id)==1;
    }
}
