/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.repository.impl;

import com.dtn.pojo.Location;
import com.dtn.repository.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Location> getLocation(String locationName) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> query = builder.createQuery(Location.class);
        Root root = query.from(Location.class);
        query = query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (locationName != null) {
            Predicate p = builder.equal(root.get("nameLocation").as(String.class), locationName.trim());
            predicates.add(p);
        }
        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
