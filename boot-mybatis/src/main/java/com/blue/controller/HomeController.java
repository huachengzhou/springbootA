package com.blue.controller;

import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/27
 **/
@RequestMapping(value = "/sys")
@Controller
public class HomeController {

    @Autowired
    private UserService userService;
}
