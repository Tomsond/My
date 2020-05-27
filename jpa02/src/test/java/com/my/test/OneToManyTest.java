package com.my.test;

import com.my.dao.CustomerDao;
import com.my.dao.LinkManDao;
import com.my.domain.Customer;
import com.my.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:jiang
 * date:2020/4/22 22:37
 * 测试一对多
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    //保存修改记得要有注解和回滚操作
    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("客户二号");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("联系人二号");

        //建立关联
        customer.getLinkMans().add(linkMan);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    //级联添加
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd(){
        Customer customer = new Customer();
        customer.setCustName("级联客户一");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("级联联系人一");

        //建立关联
        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        customerDao.save(customer);//只用做客户的添加即可
    }

    //级联删除
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeDelete(){

        Customer customer = customerDao.findOne(3l);

        customerDao.delete(customer);
    }

}
