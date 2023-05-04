/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.service;

import com.dtn.pojo.Location;
import java.util.List;

/**
 *
 * @author Nguyen0210
 */
public interface LocationService {
    List<Location> getLocation(String locationName);
}
