/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.service;

import com.dtn.pojo.Bus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen0210
 */
public interface BusService {

    List<Bus> getBuses(Map<String, String> params);

    Bus getBusById(int id);

    boolean addOrUpdateBus(Bus bus);

    boolean deleteBus(int id);
}
