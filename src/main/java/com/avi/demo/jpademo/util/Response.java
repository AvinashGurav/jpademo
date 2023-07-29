package com.avi.demo.jpademo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Response {
    
    String statusCode;
    String statusDes;
    String statusType;
    Object details;
    
    public String getStatusCode() {
        return statusCode;
    }
    
    @Override
    public String toString() {
        return "Response [statusCode=" + statusCode + ", statusDes=" + statusDes + ", statusType=" + statusType
                + ", details=" + details + "]";
    }
    
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
    public Response() {
        super();
    }
    
    public Object getDetails() {
        return details;
    }
    
    public void setDetails(Object details) {
        this.details = details;
    }
    
    public String getStatusDes() {
        return statusDes;
    }
    
    public void setStatusDes(String statusDes) {
        this.statusDes = statusDes;
    }
    
    public String getStatusType() {
        return statusType;
    }
    
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }
    
}