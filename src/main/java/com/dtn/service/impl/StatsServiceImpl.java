/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.dtn.repository.StatsRepository;
import com.dtn.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class StatsServiceImpl  implements StatsService {
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> getRevenueByQuarter(int year) {
        return this.statsRepository.getRevenueByQuarter(year);
    }
}
