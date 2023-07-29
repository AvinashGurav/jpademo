package com.avi.demo.jpademo.model;

import org.springframework.stereotype.Component;

import com.avi.demo.jpademo.entity.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest
{
    private CustomerEntity customer;
}
