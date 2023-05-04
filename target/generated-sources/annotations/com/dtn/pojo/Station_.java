package com.dtn.pojo;

import com.dtn.pojo.Location;
import com.dtn.pojo.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-04T20:44:19")
@StaticMetamodel(Station.class)
public class Station_ { 

    public static volatile SingularAttribute<Station, String> address;
    public static volatile SetAttribute<Station, Route> routeSet1;
    public static volatile SingularAttribute<Station, Location> locationId;
    public static volatile SingularAttribute<Station, String> name;
    public static volatile SingularAttribute<Station, Integer> id;
    public static volatile SetAttribute<Station, Route> routeSet;

}