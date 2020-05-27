package com.my.dao;

import com.my.domain.Role;
import com.my.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
public interface RoleDao extends JpaRepository<Role,Long>,JpaSpecificationExecutor<Role> {

}
