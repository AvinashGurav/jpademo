package com.avi.demo.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avi.demo.jpademo.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>
{

}
