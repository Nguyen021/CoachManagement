/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.repository.impl;

import com.dtn.pojo.Bus;
import com.dtn.repository.BusRepository;
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
public class BusRepositoryImpl implements BusRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateBus(Bus bus) {
        Session s = factory.getObject().getCurrentSession();
        try {
            if(bus.getId() > 0)
                s.update(bus);
            else
                s.save(bus);
            return true;
        } catch (HibernateException ex) {
            return false;
        }

    }

    @Override
    public Bus getBusById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Bus.class, id);
    }

    @Override
    public List<Bus> getBuses(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Bus> q = b.createQuery(Bus.class);
        Root root = q.from(Bus.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
            String cateId = params.get("categoryId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean deleteBus(int id) {
        Session s = factory.getObject().getCurrentSession();
        Bus b = this.getBusById(id);
        try{
            s.delete(b);
            return true;
        }catch(HibernateException ex){
            return false;
        }
    }

}
