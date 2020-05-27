package com.my;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.domain.Customer;
import com.my.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/20 22:51
 * springboot整合redis
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSpringdatajpaApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test1() throws JsonProcessingException {
        //获取redis的json格式数据
        String s = redisTemplate.boundValueOps("customer.findAll").get();
        if(null == s){
            //缓存不存在数据，查数据库
            List<Customer> customers = customerRepository.findAll();
            //存储到缓存到，使用jackson转化为json数据
            ObjectMapper objectMapper = new ObjectMapper();
            s = objectMapper.writeValueAsString(customers);
            redisTemplate.boundValueOps("customer.findAll").set(s);
            System.out.println("从数据库中读取的~~~");
        }else{
            System.out.println("从缓存中读取的~~~");
        }
        System.out.println(s);
    }

}
