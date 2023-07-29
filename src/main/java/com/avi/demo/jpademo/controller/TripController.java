package com.avi.demo.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avi.demo.jpademo.model.TripRequest;
import com.avi.demo.jpademo.service.TripService;
import com.avi.demo.jpademo.util.Response;

@RestController

public class TripController
{
    @Autowired
    TripService tripService;

    @GetMapping(value = "/trips")
    public Response getTripDetails()
    {
        return tripService.getTripDetails();

    }

    @PostMapping(value = "/trips")
    public Response saveTripDetails(@RequestBody TripRequest tripRequest)
    {
        return tripService.saveTripDetails(tripRequest);

    }

    @DeleteMapping(value = "/trips")
    public Response deleteAllTripDetails()
    {
        return tripService.deleteTrip();

    }
}
