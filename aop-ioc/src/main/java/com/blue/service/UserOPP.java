package com.blue.service;

import com.blue.domin.User;
import org.springframework.stereotype.Component;
import tool.help.Zhou_StdRandom;
import tool.help.Zhou_String;
import tool.help.Zhou_Word;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component(value = "useropp")
public class UserOPP {

    public void eachUser(){
        int num = Zhou_StdRandom.uniform(12,20);
        List<User> users = new ArrayList<>();
        User user = null;
        for (int i = 0; i < num; i++) {
            user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername(Zhou_Word.getEnglishName());
            user.setName(Zhou_Word.getChineseName());
            user.setPassword(Zhou_String.toOther(5));
            users.add(user);
        }
        users.forEach(user1 -> {
            System.out.println(""+user1);
        });
    }

    public void isFFF(String var){
        System.out.println("var:"+var);
    }
}
