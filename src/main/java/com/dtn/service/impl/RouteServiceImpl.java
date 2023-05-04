/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.dtn.pojo.Route;
import com.dtn.repository.RouteRepository;
import com.dtn.service.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepo;

    @Override
    public List<Route> getRoutes(Map<String, String> params) {
        return this.routeRepo.getRoutes(params);
    }

    @Override
    public boolean addOrUpdateRoute(Route route) {
        return this.routeRepo.addOrUpdateRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        return this.routeRepo.deleteRoute(id);
    }

    @Override
    public Route getRouteById(int id) {
        return this.routeRepo.getRouteById(id);
    }
}
