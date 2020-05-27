package com.my.test;

import com.my.dao.CustomerDao;
import com.my.dao.LinkManDao;
import com.my.dao.RoleDao;
import com.my.dao.UserDao;
import com.my.domain.Customer;
import com.my.domain.LinkMan;
import com.my.domain.Role;
import com.my.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * author:jiang
 * date:2020/4/22 22:37
 * 测试多对多
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    //多对多添加
    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        User user = new User();
        user.setUserName("多对多用户一号");

        Role role = new Role();
        role.setRoleName("多对多角色一号");

        //建立关联,否则中间表不会插入数据
        user.getRoles().add(role);
        role.getUsers().add(user);

        //user.getRoles();
        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * 对象导肮查询,一个对象查询出所有关联对象
     *
     * 一方查多方    OneToMany：
     *          get时默认懒加载                       FetchType.LAZY
     *          (不推荐)立即加载：Customer->OneToMany(fetch = FetchType.EAGER)
     * 多方查乙方    ManyToOne:
     *          get时立即加载，可以推荐，因为关联对象为一个
     */
    @Test
    @Transactional
    public void testObjectQuery(){
        User one = userDao.findOne(1l);
        Set<Role> roles = one.getRoles();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

}
