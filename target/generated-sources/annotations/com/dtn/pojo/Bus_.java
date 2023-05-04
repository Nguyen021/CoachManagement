package com.dtn.pojo;

import com.dtn.pojo.Category;
import com.dtn.pojo.Comment;
import com.dtn.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-04T20:44:19")
@StaticMetamodel(Bus.class)
public class Bus_ { 

    public static volatile SingularAttribute<Bus, String> image;
    public static volatile SetAttribute<Bus, Comment> commentSet;
    public static volatile SingularAttribute<Bus, String> name;
    public static volatile SingularAttribute<Bus, String> numberplates;
    public static volatile SingularAttribute<Bus, String> description;
    public static volatile SingularAttribute<Bus, Boolean> active;
    public static volatile SetAttribute<Bus, Trip> tripSet;
    public static volatile SingularAttribute<Bus, Integer> id;
    public static volatile SingularAttribute<Bus, Category> categoryId;

}