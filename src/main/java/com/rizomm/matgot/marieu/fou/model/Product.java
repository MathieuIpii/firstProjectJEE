package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
public class Product {
    @Id
    @GeneratedValue
    int id;

    String name;

    String description;

    Float price;

    int stock;

}
