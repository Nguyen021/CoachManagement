/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.service;

import com.dtn.pojo.Trip;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen0210
 */
public interface TripService {

    List<Object[]> getTrips(String name);

    List<Object[]> getTripDetails(int start, int end, Date startDate);

    boolean addTrip(Trip trip);

    Trip getTripById(int tripId);

    boolean deleteTrip(Trip trip);

    boolean updateTrip(Trip trip, int tripId);
}
