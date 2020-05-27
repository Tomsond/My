package com.my.dao;

import com.my.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * applicationContext.xml的jpa:repositories扫描的这里
 *      JpaRepository<T,ID>：实体类类型，主键类型
 *          封装了CRUD
 *      JpaSpecificationExecutor<T>：实体类类型
 *          封装了复杂查询（分页）
 *
 * 为什么接口就能起到CRUD作用？
 *      1.实则spring帮我们生成了一个动态代理对象 -->JdkDynamicAopProxy的invoke()生成target
 *      2.由此继承JpaRepository和JpaSpecificationExecutor
 *      3.此对象target就是SimpleJpaRepository    ---》实现了上面两个接口
 *      4.SimpleJpaRepository的findOne()去调jpa的entityManager的find()-->由此jpa和springdata结合
 *      5.遵循JPA规范，实际hibernate开始数据库操作
 */
public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {

    /**
     * 加上@query编写jpql语句
     * @param cust_Name
     * @return
     */
    @Query(value = "from Customer where custName = ?")
//    @Query(value = "select * from cst_customer where cust_name=?",nativeQuery = true) ==>原生sql
    public Customer findJpql(String cust_Name);

    /**
     * 1.方法参数列表与？位置对应
     * 2.？后添加索引也可调整位置  from Customer where custName = ?2 and custId = ?1
     * @param cust_Name
     * @param cust_id
     * @return
     */
    @Query(value = "from Customer where custName = ? and custId = ?")
    public Customer findJpql2(String cust_Name,Long cust_id);

    /**
     * 添加@Modifying
     * @param custName
     * @param custId
     */
    @Query(value = "update Customer set custName=? where custId=?")
    @Modifying
    public void update(String custName, Long custId);

    /**
     * 原生sql查询所有
     * @return
     */
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Customer> findAllBySql(); //或者Object[]

    /**
     * 方法名称规则查询
     *  1.findBy+属性名——（CustName首字母大写）
     */
    public Customer findBycustName(String custName);

    //2.模糊匹配.不能小写like (No property custNamelike found for type Customer!)
    public List<Customer> findByCustNameLike(String custName);

    //多条件查询，注意参数位置
    public Customer findByCustNameLikeAndCustIndustry(String custName,String industury);
}
