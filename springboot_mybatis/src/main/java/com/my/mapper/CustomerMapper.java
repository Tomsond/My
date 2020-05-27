package com.my.mapper;

import com.my.domain.Cst_Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/19 22:00
 */
@Mapper
public interface CustomerMapper {
    //mapper配置的信息
    public List<Cst_Customer> queryCustomer();
}
