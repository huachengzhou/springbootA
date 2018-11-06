package com.blue.spring.controller.sys;

import com.blue.common.HomeFinalString;
import com.blue.common.enums.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/
@RequestMapping(value = "/sys")
@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView sysHome(){
        ModelAndView mv = new ModelAndView(String.format("%s%s", Views.WEB_INF.getVar(), HomeFinalString.HOME));
        return mv;
    }

}
