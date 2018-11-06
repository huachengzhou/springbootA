package com.blue.spring.controller.other;

import com.blue.domin.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/6
 **/
@Controller
@RequestMapping("api/user_resource")
public class UserResourceImpl{

    @ResponseBody
    @RequestMapping(value = "/user_query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User queryUserInfoById(@RequestParam(value="id") String id) {
        return new User("123","abc");
    }

    @ResponseBody
    @RequestMapping(value = "/user_update/{id}", method = RequestMethod.PUT)
    public User updateUserInfo(@PathVariable("id") String id, @RequestBody User user) {
        user.setUserName("new");
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user_update/map", method = RequestMethod.PUT)
    public User updateUserInfoByMap(@RequestBody Map map) {
        User user = new User();
        user.setUserName(map.get("name").toString());
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user_create", method = RequestMethod.POST)
    public User createUserInfo(@RequestBody User user) {
        user.setUserName("new");
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user_delete", method = RequestMethod.DELETE)
    public User deleteUserInfo(@RequestParam(value="id") String id) {
        User user = new User();
        user.setUserName("someone deleted");
        return user;
    }

}
