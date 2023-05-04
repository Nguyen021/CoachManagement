/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.dtn.pojo.Location;
import com.dtn.repository.LocationRepository;
import com.dtn.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocation(String locationName) {
        return this.locationRepository.getLocation(locationName);
    }

}
