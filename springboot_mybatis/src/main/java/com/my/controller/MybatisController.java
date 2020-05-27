package com.my.controller;

import com.my.domain.Cst_Customer;
import com.my.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/19 22:15
 * 测试mybatis整合
 */
@Controller
public class MybatisController {

    //注入mapper
    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/mybatis")
    @ResponseBody
    public List<Cst_Customer> queryCustomer(){
        List<Cst_Customer> customers = customerMapper.queryCustomer();
        return customers;
    }
}
