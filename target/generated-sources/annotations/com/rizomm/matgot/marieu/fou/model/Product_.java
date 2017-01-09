package com.rizomm.matgot.marieu.fou.model;

import com.rizomm.matgot.marieu.fou.model.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2017-01-09T10:37:31")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile SingularAttribute<Product, String> urlPicture;

}