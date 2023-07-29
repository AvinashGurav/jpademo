package com.avi.demo.jpademo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEntity
{
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String destination;

    private Date start_date;

    private Date end_date;

    private String imageUrl;
}
