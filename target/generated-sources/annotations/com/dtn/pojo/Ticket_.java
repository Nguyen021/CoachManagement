package com.dtn.pojo;

import com.dtn.pojo.Trip;
import com.dtn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-05T09:49:59")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Date> createdDate;
    public static volatile SingularAttribute<Ticket, String> phone;
    public static volatile SingularAttribute<Ticket, Long> price;
    public static volatile SingularAttribute<Ticket, Trip> tripId;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, String> fullname;
    public static volatile SingularAttribute<Ticket, User> userId;
    public static volatile SingularAttribute<Ticket, String> email;

}