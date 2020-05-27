package com.my.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * author:jiang
 * date:2020/3/31 22:09
 * 实体类映射
 */
@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="age")
    private Integer age;

    //多对多配置
    /**
     * JoinTable:中间表配置
     * joinColumns:当前对象在中间表中的外键
     * inverseJoinColumns:对方对象在中间表中的外键
     */
    @ManyToMany(targetEntity = Role.class)
//    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)级联
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name="t_user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="t_role_id",referencedColumnName ="role_id" )}
    )
    private Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
