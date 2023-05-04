/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.controllers;

import com.dtn.service.BusService;
import com.dtn.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nguyen0210
 */
@RestController
@RequestMapping("/api")
public class ApiRouteController {
     @Autowired
    private RouteService routeService;
    
    @DeleteMapping("/route/{routeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoute(Model model, @PathVariable(value = "routeId") int id){
        this.routeService.deleteRoute(id);
    }
}
