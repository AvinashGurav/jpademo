package com.avi.demo.jpademo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class TripRequest
{

    private String name;

    private String destination;

    private String start_date;

    private String end_date;

    private String imageUrl;
}
