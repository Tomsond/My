package com.my.test;

import com.my.dao.CustomerDao;
import com.my.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;

/**
 * author:jiang
 * date:2020/4/1 22:38
 */
@RunWith(SpringJUnit4ClassRunner.class)   //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")  //spring容器的配置信息
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne(){
        Customer one = customerDao.findOne(1l);
        System.out.println(one);
    }

    /**
     * 添加或修改
     *  save():根据是否有传ID
     *      有：更新
     *      无：新增
     *  delete():
     *  findAll():
     *  count()：多少条记录                   select count(*)...
     *  exists(id)：是否存在id=？的记录        select Count(*)... where cust_id= ?
     *
     *  findOne():即时加载
     *    jpa的  em.find
     *  getOne():懒加载                    --》需要@Transactional
     *    jpa的  em.getReference
     */
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("哈");//先去查ID，没有就会insert
        customerDao.save(customer);
    }
    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setCustId(2l); //先去查ID，没有就会insert，有就update
        customer.setCustName("哈哈哈");
        customerDao.save(customer);
//        customerDao.(3l);
    }
    @Test
    public void testOther(){
        long count = customerDao.count();
        boolean exists = customerDao.exists(1l);
        System.out.println(count);
        System.out.println(exists);
    }

    /**
     * 动态查询：Specification
     *  1.实现Soecification
     *  2.重写toPredicate()
     *      Roor:获取查询的对象
     *      criteriaBuilder:查询条件
     */
    @Test
    public void testSpecification(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.单个条件查询
                Path<Object> custName = root.get("custName"); //获得属性
                Predicate predicate = criteriaBuilder.equal(custName, "哈");//构造条件

                //2.多个条件查询
                /** Path<Object> custName = root.get("custName");
                 *  Path<Object> custIndustry = root.get("custIndustry");
                 *  Predicate predicate1 = criteriaBuilder.equal(custName,"哈");
                 *  Predicate predicate2 = criteriaBuilder.equal(custIndustry,"基金");
                 *  Predicate and = criteriaBuilder.and(predicate1,predicate2)   .or或
                 */

                //3.模糊匹配,返回list
                /**必须声明属性是String类型的
                 * Predicate like = criteriaBuilder.like(custName.as(String.class),"哈%")
                 */

                return predicate;
            }
        };
        Customer one = customerDao.findOne(spec);
        System.out.println(one);
    }

    /**
     * 分页查询：cst_customer
     *  Pageable对象
     */
    @Test
    public void testPageable(){
        Pageable page = new PageRequest(0,2); //第一页开始，每页两条数据
//      customerDao.findAll(page); 不带查询条件
        Page<Customer> all = customerDao.findAll(null, page);
        System.out.println("内容："+all.getContent());
        System.out.println("总记录数："+all.getTotalElements());
        System.out.println("总页数："+all.getTotalPages());
    }

}
