/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nguyen0210
 */
@Entity
@Table(name = "shipping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipping.findAll", query = "SELECT s FROM Shipping s"),
    @NamedQuery(name = "Shipping.findById", query = "SELECT s FROM Shipping s WHERE s.id = :id"),
    @NamedQuery(name = "Shipping.findByName", query = "SELECT s FROM Shipping s WHERE s.name = :name"),
    @NamedQuery(name = "Shipping.findBySenderName", query = "SELECT s FROM Shipping s WHERE s.senderName = :senderName"),
    @NamedQuery(name = "Shipping.findBySenderPhone", query = "SELECT s FROM Shipping s WHERE s.senderPhone = :senderPhone"),
    @NamedQuery(name = "Shipping.findByReceiverName", query = "SELECT s FROM Shipping s WHERE s.receiverName = :receiverName"),
    @NamedQuery(name = "Shipping.findByReceiverPhone", query = "SELECT s FROM Shipping s WHERE s.receiverPhone = :receiverPhone"),
    @NamedQuery(name = "Shipping.findByReceiverEmail", query = "SELECT s FROM Shipping s WHERE s.receiverEmail = :receiverEmail"),
    @NamedQuery(name = "Shipping.findBySendTime", query = "SELECT s FROM Shipping s WHERE s.sendTime = :sendTime"),
    @NamedQuery(name = "Shipping.findByPrice", query = "SELECT s FROM Shipping s WHERE s.price = :price"),
    @NamedQuery(name = "Shipping.findByStatus", query = "SELECT s FROM Shipping s WHERE s.status = :status")})
public class Shipping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "sender_name")
    private String senderName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "sender_phone")
    private String senderPhone;
    @Size(max = 45)
    @Column(name = "receiver_name")
    private String receiverName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "receiver_phone")
    private String receiverPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "receiver_email")
    private String receiverEmail;
    @Column(name = "send_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Column(name = "price")
    private Long price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trip tripId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Shipping() {
    }

    public Shipping(Integer id) {
        this.id = id;
    }

    public Shipping(Integer id, String senderPhone, String receiverPhone, String receiverEmail, int status) {
        this.id = id;
        this.senderPhone = senderPhone;
        this.receiverPhone = receiverPhone;
        this.receiverEmail = receiverEmail;
        this.status = status;
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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Shipping)) {
            return false;
        }
        Shipping other = (Shipping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dtn.pojo.Shipping[ id=" + id + " ]";
    }
    
}
