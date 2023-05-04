/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.repository.impl;

import com.dtn.pojo.Bus;
import com.dtn.pojo.Route;
import com.dtn.pojo.Station;
import com.dtn.pojo.Trip;
import com.dtn.pojo.User;
import com.dtn.repository.TripRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class TripRepositoryImpl implements TripRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> getTripDetails(int start, int end, Date startDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootTrip = query.from(Trip.class);
        Root rootRoute = query.from(Route.class);
        Root rootSationStart = query.from(Station.class);
        Root rootStationEnd = query.from(Station.class);
        Root rootBus = query.from(Bus.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootTrip.get("routeId"), rootRoute.get("id")));
        predicates.add(builder.equal(rootTrip.get("busId"), rootBus.get("id")));
        predicates.add(builder.equal(rootTrip.get("isStarted"), 0));
        predicates.add(builder.equal(rootRoute.get("startingPoint"), rootSationStart.get("id")));
        predicates.add(builder.equal(rootSationStart.get("locationId"), start));
        predicates.add(builder.equal(rootRoute.get("endingPoint"), rootStationEnd.get("id")));
        predicates.add(builder.equal(rootStationEnd.get("locationId"), end));
        predicates.add(builder.equal(builder.function("date", Date.class, rootTrip.get("startTime")), startDate));

        query.multiselect(
                rootTrip.get("name"),
                rootTrip.get("startTime"),
                rootTrip.get("endTime"),
                rootTrip.get("emptySeats"),
                rootRoute.get("name"),
                rootSationStart.get("name"),
                rootStationEnd.get("name"),
                rootBus.get("name"),
                rootBus.get("image"),
                rootBus.get("id"),
                rootRoute.get("id"),
                rootTrip.get("id")
        );

        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getTrips(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootTrip = query.from(Trip.class);
        Root rootRoute = query.from(Route.class);
        Root rootBus = query.from(Bus.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(builder.like(rootTrip.get("name").as(String.class), "%" + name.trim() + "%"));
        }
        predicates.add(builder.equal(rootTrip.get("routeId"), rootRoute.get("id")));

        predicates.add(builder.equal(rootTrip.get("busId"), rootBus.get("id")));

        query.multiselect(rootTrip.get("id"), rootTrip.get("name"),
                rootTrip.get("startTime"), rootTrip.get("endTime"),
                rootTrip.get("emptySeats"), rootTrip.get("description"),
                rootTrip.get("unitprice"), rootTrip.get("isStarted"),
                rootTrip.get("isCanceled"), rootRoute.get("name"),
                rootBus.get("name"));

        query.where(predicates.toArray(new Predicate[]{}));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(trip);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Trip getTripById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Trip.class, id);
    }

    @Override
    public boolean deleteTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(trip);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean updateTrip(Trip trip, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Trip> t= builder.createCriteriaUpdate(Trip.class);
        Root root = t.from(Trip.class);

        t.set("name", trip.getName());
        t.set("startTime", trip.getStartTime());
        t.set("endTime", trip.getEndTime());
        t.set("describe", trip.getDescription());
        t.set("routeId", trip.getRouteId());
        t.set("coachId", trip.getBusId());

        t.set("isStarted", trip.getIsStarted());
        t.set("isCanceled", trip.getIsCanceled());
        t.set("emptySeats", trip.getEmptySeats());
        
        t = t.where(builder.equal(root.get("id").as(Integer.class), id));

        return session.createQuery(t).executeUpdate() > 0;
    }

}
