package com.avi.demo.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avi.demo.jpademo.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>
{

}
