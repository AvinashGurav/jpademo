package com.avi.demo.jpademo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avi.demo.jpademo.entity.CustomerEntity;
import com.avi.demo.jpademo.model.Header;
import com.avi.demo.jpademo.model.OrderRequest;
import com.avi.demo.jpademo.repository.CustomerRepository;
import com.avi.demo.jpademo.repository.ProductRepository;
import com.avi.demo.jpademo.util.Response;
import com.avi.demo.jpademo.util.ResponseBuilder;
import com.avi.demo.jpademo.util.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrderController
{
    @Autowired
    private ApplicationContext context;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Response placeOrder(@RequestBody OrderRequest request)
    {
        ResponseBuilder responseBuilder = context.getBean(ResponseBuilder.class);
        customerRepository.save(request.getCustomer());
        return responseBuilder.createResponse(StatusCode.SUCCESS, StatusCode.SUCCESSFULLY_SAVED_RECORD,
            StatusCode.SUCCESS_STATUS_TYPE, null);
    }

    @GetMapping("/getAllOrders")
    public Response findAllOrder()
    {
        ResponseBuilder responseBuilder = context.getBean(ResponseBuilder.class);
        List<CustomerEntity> lst = customerRepository.findAll();
        return responseBuilder.createResponse(StatusCode.SUCCESS, StatusCode.SUCCESSFULLY_FETCHED_RECORD,
            StatusCode.SUCCESS_STATUS_TYPE, lst);
    }

    private Header getHeader(HttpHeaders httpHeaders)
    {
        Map<String, String> headerMap = httpHeaders.toSingleValueMap();
        final ObjectMapper mapper = new ObjectMapper();
        Header header = mapper.convertValue(headerMap, Header.class);
        return header;
    }
}
