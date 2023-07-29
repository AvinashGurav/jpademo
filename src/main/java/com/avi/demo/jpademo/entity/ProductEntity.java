package com.avi.demo.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity
{
    @Id
    private int pid;

    private String productName;

    private int qty;

    private int price;
}
