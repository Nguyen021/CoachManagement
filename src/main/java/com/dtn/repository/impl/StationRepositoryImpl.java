/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.repository.impl;

import com.dtn.pojo.Station;
import com.dtn.repository.StationRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nguyen0210
 */
@Repository
@Transactional
public class StationRepositoryImpl implements StationRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Station> getStation() {
         Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Station");
        return q.getResultList();
    }
}
