package com.dtn.pojo;

import com.dtn.pojo.Bus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-05T09:49:59")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SetAttribute<Category, Bus> busSet;
    public static volatile SingularAttribute<Category, Integer> totalseating;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Integer> id;

}