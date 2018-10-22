package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/22
 **/
@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/index")
    public String index(){
        logger.info("index");
        return "index";
    }
}
