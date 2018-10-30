package com.blue.dal.mapper;

import com.blue.dal.entity.UserBoot;
import com.blue.dal.entity.UserBootExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBootMapper {
    int countByExample(UserBootExample example);

    int deleteByExample(UserBootExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserBoot record);

    int insertSelective(UserBoot record);

    List<UserBoot> selectByExample(UserBootExample example);

    UserBoot selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserBoot record, @Param("example") UserBootExample example);

    int updateByExample(@Param("record") UserBoot record, @Param("example") UserBootExample example);

    int updateByPrimaryKeySelective(UserBoot record);

    int updateByPrimaryKey(UserBoot record);
}