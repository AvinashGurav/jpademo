package com.avi.demo.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avi.demo.jpademo.entity.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Integer>
{

}
