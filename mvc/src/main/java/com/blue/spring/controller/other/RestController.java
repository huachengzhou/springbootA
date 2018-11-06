package com.blue.spring.controller.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/6
 **/
@RequestMapping(value = "/restful")
@Controller
public class RestController {

    @GetMapping(value = "/helloWorld")
    public ModelAndView sysHome(){
        ModelAndView mv = new ModelAndView(String.format("%s%s", "restful/", "helloWorld"));
        System.out.println("------------------");
        return mv;
    }

}
