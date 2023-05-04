/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nguyen0210
 */
@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findById", query = "SELECT t FROM Trip t WHERE t.id = :id"),
    @NamedQuery(name = "Trip.findByName", query = "SELECT t FROM Trip t WHERE t.name = :name"),
    @NamedQuery(name = "Trip.findByStartTime", query = "SELECT t FROM Trip t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Trip.findByEndTime", query = "SELECT t FROM Trip t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "Trip.findByEmptySeats", query = "SELECT t FROM Trip t WHERE t.emptySeats = :emptySeats"),
    @NamedQuery(name = "Trip.findByDescription", query = "SELECT t FROM Trip t WHERE t.description = :description"),
    @NamedQuery(name = "Trip.findByUnitprice", query = "SELECT t FROM Trip t WHERE t.unitprice = :unitprice"),
    @NamedQuery(name = "Trip.findByIsStarted", query = "SELECT t FROM Trip t WHERE t.isStarted = :isStarted"),
    @NamedQuery(name = "Trip.findByIsCanceled", query = "SELECT t FROM Trip t WHERE t.isCanceled = :isCanceled")})
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empty_seats")
    private int emptySeats;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "unitprice")
    private Long unitprice;
    @Column(name = "is_started")
    private Boolean isStarted;
    @Column(name = "is_canceled")
    private Boolean isCanceled;
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bus busId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    private Set<Shipping> shippingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    private Set<Ticket> ticketSet;

    public Trip() {
    }

    public Trip(Integer id) {
        this.id = id;
    }

    public Trip(Integer id, String name, Date startTime, Date endTime, int emptySeats) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.emptySeats = emptySeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getEmptySeats() {
        return emptySeats;
    }

    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Long unitprice) {
        this.unitprice = unitprice;
    }

    public Boolean getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(Boolean isStarted) {
        this.isStarted = isStarted;
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public Bus getBusId() {
        return busId;
    }

    public void setBusId(Bus busId) {
        this.busId = busId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    @XmlTransient
    public Set<Shipping> getShippingSet() {
        return shippingSet;
    }

    public void setShippingSet(Set<Shipping> shippingSet) {
        this.shippingSet = shippingSet;
    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dtn.pojo.Trip[ id=" + id + " ]";
    }
    
}
