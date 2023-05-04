/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.dtn.pojo.Trip;
import com.dtn.repository.TripRepository;
import com.dtn.service.TripService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepo;

    @Override
    public List<Object[]> getTripDetails(int start, int end, Date startDate) {
        return this.tripRepo.getTripDetails(end, end, startDate);
    }

    @Override
    public List<Object[]> getTrips(String name) {
        return this.tripRepo.getTrips(name);
    }

    @Override
    public boolean addTrip(Trip trip) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(trip.getStartTime().toString(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(trip.getEndTime().toString(), formatter);

        Date startDateTime = Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());
        Date endDateTime = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());

        try {
            trip.setIsStarted(Boolean.FALSE);
            trip.setIsCanceled(Boolean.FALSE);
            trip.setStartTime(startDateTime);
            trip.setEndTime(endDateTime);
            return this.tripRepo.addTrip(trip);
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Trip getTripById(int tripId) {
        return this.tripRepo.getTripById(tripId);
    }

    @Override
    public boolean deleteTrip(Trip trip) {
         return this.tripRepo.deleteTrip(trip);
    }

    @Override
    public boolean updateTrip(Trip trip, int tripId) {
         return this.tripRepo.updateTrip(trip, tripId);
    }

}
