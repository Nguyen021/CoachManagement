/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.dtn.pojo.Station;
import com.dtn.repository.StationRepository;
import com.dtn.service.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class StationServiceImpl implements StationService{
     @Autowired
    private StationRepository stationRepos;
    @Override
    public List<Station> getStation() {
        return this.stationRepos.getStation();
    }
    
}
