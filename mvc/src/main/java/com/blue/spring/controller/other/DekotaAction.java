package com.blue.spring.controller.other;

import com.alibaba.fastjson.JSONObject;
import com.blue.domin.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/6
 **/
@Controller
@Scope("prototype")//改为多列模式
public class DekotaAction {

    /**
     * 日志实例
     */
    private static final Logger logger = Logger.getLogger(DekotaAction.class.getSimpleName());

    @ResponseBody
    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
    public String hello() {
        return "你好！hello";
    }

    @ResponseBody
    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
    public String say(@PathVariable(value = "msg") String msg) {
        return "{\"msg\":\"you say:'" + msg + "'\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") int id) {
        logger.info("获取人员信息id=" + id);
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(30);
        person.setId(id);
        return person;
    }

    @ResponseBody
    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
    public Object deletePerson(@PathVariable("id") int id) {
        logger.info("删除人员信息id=" + id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "删除人员信息成功");
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Object addPerson(Person person) {
        logger.info("注册人员信息成功id=" + person.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "注册人员信息成功");
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public Object updatePerson(Person person) {
        logger.info("更新人员信息id=" + person.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "更新人员信息成功");
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.PATCH)
    public List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {

        logger.info("查询人员name like " + name);
        List<Person> lstPersons = new ArrayList<Person>();

        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setAge(25);
        person.setId(101);
        lstPersons.add(person);

        Person person2 = new Person();
        person2.setName("李四");
        person2.setSex("女");
        person2.setAge(23);
        person2.setId(102);
        lstPersons.add(person2);

        Person person3 = new Person();
        person3.setName("王五");
        person3.setSex("男");
        person3.setAge(27);
        person3.setId(103);
        lstPersons.add(person3);
        return lstPersons;
    }

}