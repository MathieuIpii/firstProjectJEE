package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */
@Entity
public class Category {
    @NotNull
    int id;
    String name;
}
