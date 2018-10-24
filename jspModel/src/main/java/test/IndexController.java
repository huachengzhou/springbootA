package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/22
 **/
@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/index",method = {RequestMethod.GET})
    public String index(){
        logger.info("index");
        return "index";
    }
}
