package com.my.test;

import com.my.dao.CustomerDao;
import com.my.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author:jiang
 * date:2020/4/1 22:38
 */
@RunWith(SpringJUnit4ClassRunner.class)   //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")  //spring容器的配置信息
public class CustomerJpqlTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindJpql(){
        Customer one = customerDao.findJpql("哈哈");
        System.out.println(one);
    }

    //...普通的查询省略

    /**
     * 修改需要事务的支持，不然修改报错或者失败
     * Rollbak默认会自动回滚
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateJpql(){
        customerDao.update("哈",2l);
    }


    /**
     * 原生sql查询所有
     */
    @Test
    public void testFindAllBySql(){
        List<Customer> list = customerDao.findAllBySql();
        for(int i=0; i<list.size();i++){
            System.out.println("hello"+i);
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void testFindByCustName(){
        Customer customer = customerDao.findBycustName("哈");
        System.out.println(customer);
    }

    @Test
    public void testFindByCustNameLike(){
        List<Customer> customer = customerDao.findByCustNameLike("哈");
        System.out.println(customer);
    }
}
