package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */

public class Category {

    @Id
    @GeneratedValue
    private Long id;

    public Category(){

    }

    public Long getId() {
        return id;
    }
}
