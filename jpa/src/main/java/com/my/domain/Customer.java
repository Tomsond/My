package com.my.domain;

import javax.persistence.*;

/**
 * author:jiang
 * date:2020/3/9 21:52
 * 客户实体类
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    /**
     * 主键生成策略：GenerationType
     *      常用
     *      .IDENTITY：主键自增（mysql）
     *      .SEQUENCE：序列（oracle）
     *      不常用
     *      .AUTO：自动的帮我们选择主键生成策略
     *      .TABLE：通过一张表的形式帮我们完成自增（新建表，字段：序列+nextval）
     *
     */
    @Id                                                 //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增
    @Column(name = "cust_id")
    private Long custId;//客户id

    @Column(name = "cust_name")
    private String custName;//客户名称

    @Column(name = "cust_source")
    private String custSource;//客户来源

    @Column(name = "cust_industry")
    private String custIndustry;//客户行业

    @Column(name = "cust_level")
    private String custLevel;//客户级别

    @Column(name = "cust_address")
    private String custAddress;//客户联系地址

    @Column(name = "cust_mobile")
    private String custMobile;//客户联系电话


    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }
}
