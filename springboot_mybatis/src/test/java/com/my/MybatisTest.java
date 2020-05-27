package com.my;

import com.my.domain.Cst_Customer;
import com.my.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/19 22:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void test1(){
        List<Cst_Customer> cst_customers = customerMapper.queryCustomer();
        System.out.println(cst_customers);
    }
}
