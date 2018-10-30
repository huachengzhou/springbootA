package com.blue.dal.dao;

import com.blue.dal.entity.UserBoot;
import com.blue.dal.entity.UserBootExample;
import com.blue.dal.mapper.UserBootMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/30
 **/
@Repository
public class UserBootDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Lazy
    @Autowired
    private UserBootMapper userBootMapper;

    public boolean saveUserBoot(UserBoot userBoot)throws SQLException{
        userBootMapper.insertSelective(userBoot);
        return userBootMapper.insertSelective(userBoot) >=1;
    }

    public List<UserBoot> findListUserBoot(UserBoot userBoot)throws SQLException{
        UserBootExample example = new UserBootExample();
        UserBootExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        if (StringUtils.isNotEmpty(userBoot.getName())){
            criteria.andNameLike(String.format("%s%s%s","%",userBoot.getName(),"%"));
        }
        return userBootMapper.selectByExample(example);
    }


}
