/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.controllers;

import com.dtn.pojo.Category;
import com.dtn.pojo.Station;
import com.dtn.service.CategoryService;
import com.dtn.service.LocationService;
import com.dtn.service.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nguyen0210
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private LocationService locationService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private StationService stationService;
    
    @ModelAttribute
    public void commonAttributes(Model model) {
        List<Category> cates = this.categoryService.getCategory();
        model.addAttribute("categories", cates);
        List<Station> sta = this.stationService.getStation();
        model.addAttribute("stations", sta);
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("location", this.locationService.getLocation(null));
        return "index";
    }
    
    @GetMapping("/login")
    public String loginView(){
        return "login";
    }
}
