package com.dtn.pojo;

import com.dtn.pojo.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-04T20:44:19")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile SingularAttribute<Location, String> nameLocation;
    public static volatile SetAttribute<Location, Station> stationSet;

}