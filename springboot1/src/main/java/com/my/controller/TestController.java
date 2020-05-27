package com.my.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * author:jiang
 * date:2020/5/6 22:34
 * controller演示：类似springMVC
 */
@Controller
@ConfigurationProperties(prefix = "person") //自动扫描person的,如果先写这里，那么yml定义person就会有属性提示
public class TestController {

    /**
     * 1.通过@Value获取yml属性的值
     */
//    @Value("${person.name}")
//    private String name;


    /**
     *2.通过@ConfigurationProperties
     *  注意：要生成属性的getter/setter方法，否则读取不到值null
     */
    private String name;
    private String age;

    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
//        return "hello springboot";
        return "hello : "+name+age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
