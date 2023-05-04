/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.repository.impl;

import com.dtn.pojo.Route;
import com.dtn.repository.RouteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Route> getRoutes(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root root = q.from(Route.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
            String stationId = params.get("startingPoint");
            if (stationId != null) {
                Predicate p = b.equal(root.get("startingPoint"), Integer.parseInt(stationId));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateRoute(Route route) {
        Session s = factory.getObject().getCurrentSession();
        try {
            if (route.getId() > 0) {
                s.update(route);
            } else {
                s.save(route);
            }
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public Route getRouteById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Route.class, id);
    }

    @Override
    public boolean deleteRoute(int id) {
        Session s = factory.getObject().getCurrentSession();
        Route r = this.getRouteById(id);
        try {
            s.delete(r);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

}
