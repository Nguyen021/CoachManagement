/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.controllers;

import com.dtn.pojo.Bus;
import com.dtn.pojo.Route;
import com.dtn.pojo.Trip;
import com.dtn.service.BusService;
import com.dtn.service.RouteService;
import com.dtn.service.StatsService;
import com.dtn.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen0210
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TripService tripService;

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;
    
    @Autowired
    private StatsService statsService;

    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("buses", this.busService.getBuses(null));
        model.addAttribute("routes", this.routeService.getRoutes(null));
    }
//    1

    @GetMapping("/bus-manage")
    public String buses(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus-manage";
    }
//2

    @PostMapping("/bus-manage")
    public String addBus(Model model, @ModelAttribute(value = "bus") Bus bus) {
        if (this.busService.addOrUpdateBus(bus) == true) {
            return "redirect:/admin/bus-manage";
        } else {
            model.addAttribute("errMsg", "Lỗi khi thêm hoặc cập nhập bus");
        }
        return "bus-manage";
    }
//3

    @GetMapping("/bus-manage/{busId}")
    public String UpdateBus(Model model, @PathVariable(value = "busId") int id) {
        model.addAttribute("bus", this.busService.getBusById(id));
        return "bus-manage";
    }

    
//    Tuyến Xe
    @GetMapping("/route-manage")
    public String route(Model model) {
        model.addAttribute("route", new Route());
        return "route-manage";
    }

    @PostMapping("/route-manage")
    public String addRoute(Model model, @ModelAttribute(value = "route") Route route) {
        if (this.routeService.addOrUpdateRoute(route) == true) {
            return "redirect:/admin/route-manage";
        } else {
            model.addAttribute("errMsg", "Lỗi khi thêm hoặc cập nhập route");
        }
        return "route-manage";
    }
    
    @GetMapping("/route-manage/{routeId}")
    public String UpdateRoute(Model model, @PathVariable(value = "routeId") int id) {
        model.addAttribute("route", this.routeService.getRouteById(id));
        return "route-manage";
    }
     
    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(name = "year", defaultValue = "2022") Integer year){
         model.addAttribute("revenueQuarter", this.statsService.getRevenueByQuarter(year));
        return "stats";
    }
    
//    Chuyến Xe
    @GetMapping("/trip-manage")
    public String tripManage(Model model) {
        model.addAttribute("trip", new Trip());
        return "trip-manage";
    }

}
