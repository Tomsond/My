package com.my.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * author:jiang
 * date:2020/3/15 15:36
 * Jpa工具类实现
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    /**
     * 1.初次getEntityManager(),创建factory对象--static
     * 2.再次getEntityManager(),直接拿factory对象
     */

    static {
        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    //创建获取EntityManager对象
    public  static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
