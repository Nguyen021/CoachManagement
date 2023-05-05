package com.dtn.pojo;

import com.dtn.pojo.Station;
import com.dtn.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-05T09:49:59")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Station> startingPoint;
    public static volatile SingularAttribute<Route, Station> endingPoint;
    public static volatile SingularAttribute<Route, Long> price;
    public static volatile SingularAttribute<Route, String> name;
    public static volatile SetAttribute<Route, Trip> tripSet;
    public static volatile SingularAttribute<Route, Integer> id;

}