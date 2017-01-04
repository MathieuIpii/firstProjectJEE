package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Mathieu on 17/11/2016.
 */

public class OrderLine {

    private Product prod;
    private int quantity;

    public OrderLine(Product prod, int quantity) {
        this.prod = prod;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }
}
