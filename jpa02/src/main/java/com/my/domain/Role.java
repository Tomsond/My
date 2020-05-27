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
@Table(name="t_role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

    //多对多配置
//    @ManyToMany(targetEntity = User.class)

    //被动一方应该放弃外键维护，否则会报主键ID重复
//    @JoinTable(name = "t_user_role",
//            joinColumns = {@JoinColumn(name="t_role_id",referencedColumnName = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "t_user_id",referencedColumnName = "user_id")}
//    )

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
