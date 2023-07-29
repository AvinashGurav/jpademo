package com.avi.demo.jpademo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.avi.demo.jpademo.constant.CBSConstants;
import com.avi.demo.jpademo.entity.TripEntity;
import com.avi.demo.jpademo.model.TripRequest;
import com.avi.demo.jpademo.repository.TripRepository;
import com.avi.demo.jpademo.service.TripService;
import com.avi.demo.jpademo.util.DateValidation;
import com.avi.demo.jpademo.util.Response;
import com.avi.demo.jpademo.util.ResponseBuilder;
import com.avi.demo.jpademo.util.StatusCode;

@Service
public class TripServiceImpl implements TripService
{
    @Autowired
    TripRepository tripRepository;

    @Autowired
    DateValidation dateValidation;

    @Autowired
    private ApplicationContext context;

    @Override
    public Response getTripDetails()
    {
        ResponseBuilder responseBuilder = context.getBean(ResponseBuilder.class);
        List<TripEntity> lstTripEntity = tripRepository.findAll();
        return responseBuilder.createResponse(StatusCode.SUCCESS, StatusCode.SUCCESSFULLY_FETCHED_RECORD,
            StatusCode.SUCCESS_STATUS_TYPE, convertToTripRequest(lstTripEntity));

    }

    @Override
    public Response saveTripDetails(TripRequest tripRequest)
    {
        ResponseBuilder responseBuilder = context.getBean(ResponseBuilder.class);
        TripEntity tripEntity = convertValue(tripRequest);
        tripRepository.save(tripEntity);
        return responseBuilder.createResponse(StatusCode.SUCCESS, StatusCode.SUCCESSFULLY_SAVED_RECORD,
            StatusCode.SUCCESS_STATUS_TYPE, null);
    }

    private TripEntity convertValue(TripRequest tripRequest)
    {
        TripEntity tripEntity = new TripEntity();
        tripEntity.setName(tripRequest.getName());
        tripEntity.setDestination(tripRequest.getDestination());
        tripEntity.setImageUrl(tripRequest.getImageUrl());
        tripEntity.setStart_date(dateValidation.getDate(tripRequest.getStart_date(), CBSConstants.DATE_FORMAT));
        tripEntity.setEnd_date(dateValidation.getDate(tripRequest.getEnd_date(), CBSConstants.DATE_FORMAT));
        return tripEntity;
    }

    private List<TripRequest> convertToTripRequest(List<TripEntity> lstTripEntity)
    {
        ArrayList<TripRequest> lst = new ArrayList<>();
        for (TripEntity tripEntity : lstTripEntity) {
            TripRequest tripRequest = new TripRequest();
            tripRequest.setName(tripEntity.getName());
            tripRequest.setDestination(tripEntity.getDestination());
            tripRequest.setImageUrl(tripEntity.getImageUrl());
            tripRequest.setStart_date(dateValidation.convertDateToStr(tripEntity.getStart_date()));
            tripRequest.setEnd_date(dateValidation.convertDateToStr(tripEntity.getEnd_date()));
            lst.add(tripRequest);
        }
        return lst;
    }

    @Override
    public Response deleteTrip()
    {
        ResponseBuilder responseBuilder = context.getBean(ResponseBuilder.class);
        tripRepository.deleteAll();
        return responseBuilder.createResponse(StatusCode.SUCCESS, StatusCode.SUCCESSFULLY_DELETED_RECORD,
            StatusCode.SUCCESS_STATUS_TYPE, null);

    }
}
