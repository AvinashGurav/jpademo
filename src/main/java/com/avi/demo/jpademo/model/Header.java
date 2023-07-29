package com.avi.demo.jpademo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Header implements Serializable
{
    private static final long serialVersionUID = 1L;

    @JsonProperty("todaysdate")

    private String todaysdate;

}
