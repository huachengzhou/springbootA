package com.blue.service;

import com.blue.dal.dao.UserBootDao;
import com.blue.dal.entity.UserBoot;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/30
 **/
@Service
public class UserBootService {

    @Autowired
    private UserBootDao userBootDao;

    public boolean saveUserBoot(UserBoot userBoot)throws Exception{
        if (StringUtils.isEmpty(userBoot.getId())){
            userBoot.setId(UUID.randomUUID().toString().substring(1,12));
        }
        return userBootDao.saveUserBoot(userBoot);
    }

    public List<UserBoot> findListUserBoot(UserBoot userBoot)throws Exception{
        return userBootDao.findListUserBoot(userBoot);
    }

}
