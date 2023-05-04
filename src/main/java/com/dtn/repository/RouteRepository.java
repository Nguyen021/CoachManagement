/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.repository;

import com.dtn.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen0210
 */
public interface RouteRepository {

    List<Route> getRoutes(Map<String, String> params);

    boolean addOrUpdateRoute(Route route);

    boolean deleteRoute(int id);

    Route getRouteById(int id);
}
