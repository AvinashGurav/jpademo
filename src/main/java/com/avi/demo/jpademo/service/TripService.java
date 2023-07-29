package com.avi.demo.jpademo.service;

import com.avi.demo.jpademo.model.TripRequest;
import com.avi.demo.jpademo.util.Response;

public interface TripService
{
    public Response getTripDetails();

    public Response saveTripDetails(TripRequest tripRequest);

    public Response deleteTrip();
}
