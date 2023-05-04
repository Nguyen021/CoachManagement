package com.dtn.pojo;

import com.dtn.pojo.Bus;
import com.dtn.pojo.Route;
import com.dtn.pojo.Shipping;
import com.dtn.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-04T20:44:19")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Bus> busId;
    public static volatile SingularAttribute<Trip, Boolean> isCanceled;
    public static volatile SingularAttribute<Trip, String> description;
    public static volatile SingularAttribute<Trip, Boolean> isStarted;
    public static volatile SingularAttribute<Trip, Long> unitprice;
    public static volatile SingularAttribute<Trip, Integer> emptySeats;
    public static volatile SingularAttribute<Trip, Route> routeId;
    public static volatile SetAttribute<Trip, Ticket> ticketSet;
    public static volatile SingularAttribute<Trip, String> name;
    public static volatile SetAttribute<Trip, Shipping> shippingSet;
    public static volatile SingularAttribute<Trip, Date> startTime;
    public static volatile SingularAttribute<Trip, Integer> id;
    public static volatile SingularAttribute<Trip, Date> endTime;

}