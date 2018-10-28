package com.blue.mapper;

import com.blue.entity.UserBoot;

public interface UserBootMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserBoot record);

    int insertSelective(UserBoot record);

    UserBoot selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserBoot record);

    int updateByPrimaryKey(UserBoot record);
}