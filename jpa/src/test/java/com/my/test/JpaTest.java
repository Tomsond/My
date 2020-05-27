package com.my.test;

import com.my.domain.Customer;
import com.my.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * author:jiang
 * date:2020/3/9 22:14
 * Jpa单元测试类
 */
public class JpaTest {
    /**
     * 1.加载配置文件创建工厂对象
     * 2.获取实体管理器
     * 3.开启事务
     * 4.CRUD
     * 5.提交事务
     * 6.释放资源
     */

    @Test
    public void Save(){
        //1
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
//
//        //2
//        EntityManager manager = factory.createEntityManager();

        //使用工具类
        EntityManager manager = JpaUtils.getEntityManager();
        //3.
        EntityTransaction transaction = manager.getTransaction();

        //4.
        transaction.begin();

        //5.增
        Customer customer = new Customer();
        customer.setCustName("JPA测试11号");
        customer.setCustIndustry("IT");
        manager.persist(customer);
//        查：find(Customer.class,1l);根据id查询
//        Customer customer = manager.find(Customer.class, 1l);
//        System.out.println(customer);

        //6.
        transaction.commit();

        //7.释放资源，先开后关
        manager.close();
//        factory.close();

    }

    /**
     * 测试根据id查询：find()   即时加载（查询库），缺点就是耗资源不建议
     */
    @Test
    public  void testFind(){
        EntityManager manager = JpaUtils.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Customer customer = manager.find(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        manager.close();
    }

    /**
     * 测试根据id查询：getRefrence()  懒加载（不会立即查询），随用随加载
     */
    @Test
    public  void testGetRefrence(){
        EntityManager manager = JpaUtils.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Customer customer = manager.getReference(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        manager.close();
    }

    //manager.remove(customer);  1.先find。 2.删除。
    //manager.merge(customer);

}
