package com.my.test;

import com.my.domain.Customer;
import com.my.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Observable;

/**
 * author:jiang
 * date:2020/3/9 22:14
 * Jplql
 */
public class JpqlTest {

    /** 一样sql，操作的是对象
     * 查询所有：from Customer
     * 根据排序: from Customer order by custId
     * 统计查询： select count(custId) from Customer     注意：query.getSingleResult()
     *
     * 分页查询：查询所有后，query.setFirstResult(0);  query.setMaxResults(2);
     *
     * 根据条件查询： from Customer where name like ?     query.setParameters(1,"哈哈")
     */
    @Test
    public void findAll(){

        //使用工具类
        EntityManager manager = JpaUtils.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        //开始事务
        transaction.begin();
        //拿到查询对象
        Query query = manager.createQuery("from com.my.domain.Customer"); //from Customer
        //执行查询
        List resultList = query.getResultList();
        //遍历结果集
        for (Object str:resultList) {
            System.out.println(str);
        }

        transaction.commit();

        //7.释放资源，先开后关
        manager.close();
//        factory.close();

    }


}
