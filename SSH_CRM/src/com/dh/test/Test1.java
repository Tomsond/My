package com.dh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:web/WEB-INF/applicationContext.xml")
public class Test1 {
    @Resource(name="testSpring")
    private TestSpring ts;

    @Test
    public void fun1(){
        System.out.println(ts.getName());
    }
}
