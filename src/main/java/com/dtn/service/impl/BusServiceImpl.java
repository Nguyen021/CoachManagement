/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dtn.pojo.Bus;
import com.dtn.repository.BusRepository;
import com.dtn.service.BusService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen0210
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepo;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Bus> getBuses(Map<String, String> params) {
        return this.busRepo.getBuses(params);
    }

    @Override
    public Bus getBusById(int id) {
        return this.busRepo.getBusById(id);
    }

    @Override
    public boolean addOrUpdateBus(Bus bus) {
        if (!bus.getFile().isEmpty()) {
//             if (bus.getFile() != null) {
            try {
                Map rs = this.cloudinary.uploader().upload(bus.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                
                bus.setImage(rs.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(BusServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.busRepo.addOrUpdateBus(bus);
    }

    @Override
    public boolean deleteBus(int id) {
        return this.busRepo.deleteBus(id);
    }

}
