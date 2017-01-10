package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */

public class OrderLine {

    private int id;

    public int getProd() {
        return id;
    }

    public void setProd(int id) {
        this.id = id;
    }

}
