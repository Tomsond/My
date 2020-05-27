package com.my.domain;


/**
 * author:jiang
 * date:2020/3/31 22:09
 * 实体类映射
 */
public class Cst_Customer {

    private Long cust_id;

    private String cust_address;

    private String cust_industry;

    private String cust_level;

    private String cust_mobile;

    private String cust_name;

    private String cust_source;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    @Override
    public String toString() {
        return "Cst_Customer{" +
                "cust_id=" + cust_id +
                ", cust_address='" + cust_address + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                ", cust_name='" + cust_name + '\'' +
                ", cust_source='" + cust_source + '\'' +
                '}';
    }
}
