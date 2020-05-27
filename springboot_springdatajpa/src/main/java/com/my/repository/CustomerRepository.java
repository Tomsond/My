package com.my.repository;

import com.my.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author:jiang
 * date:2020/5/20 22:09
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findAll();
}
