package com.dtn.pojo;

import com.dtn.pojo.Trip;
import com.dtn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-05T09:49:59")
@StaticMetamodel(Shipping.class)
public class Shipping_ { 

    public static volatile SingularAttribute<Shipping, String> senderPhone;
    public static volatile SingularAttribute<Shipping, String> senderName;
    public static volatile SingularAttribute<Shipping, String> receiverPhone;
    public static volatile SingularAttribute<Shipping, String> receiverName;
    public static volatile SingularAttribute<Shipping, Long> price;
    public static volatile SingularAttribute<Shipping, String> name;
    public static volatile SingularAttribute<Shipping, Trip> tripId;
    public static volatile SingularAttribute<Shipping, Integer> id;
    public static volatile SingularAttribute<Shipping, User> userId;
    public static volatile SingularAttribute<Shipping, String> receiverEmail;
    public static volatile SingularAttribute<Shipping, Date> sendTime;
    public static volatile SingularAttribute<Shipping, Integer> status;

}