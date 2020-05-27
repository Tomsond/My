package com.my;

import com.my.domain.Customer;
import com.my.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/20 22:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSpringdatajpaApplication.class)
public class JpaTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test1(){
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
    }
}
