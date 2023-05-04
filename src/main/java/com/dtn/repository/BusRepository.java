/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.repository;

import com.dtn.pojo.Bus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen0210
 */
public interface BusRepository {
    List<Bus> getBuses(Map<String, String> params);
    boolean addOrUpdateBus(Bus bus);
    boolean deleteBus(int id);
    Bus getBusById(int id);
}
