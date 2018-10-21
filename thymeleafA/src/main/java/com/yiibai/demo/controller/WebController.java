package com.yiibai.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/21
 **/
@Controller
public class WebController {

    @RequestMapping(value = "/index")
    public String index() {
        return "/index";
    }
}