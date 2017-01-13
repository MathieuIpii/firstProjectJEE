package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.rizomm.matgot.marieu.fou.model.Cart.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Cart c"),
        @NamedQuery(name = DELETE_ALL, query = " delete from Cart"),
        @NamedQuery(name = COUNT_ALL, query = "select count(c.quantity) from Cart c")
})
public class Cart implements Serializable{

    public static final String FIND_ALL = "Cart.findAllProductCart";
    public static final String DELETE_ALL = "Cart.deleteAllProductCart";
    public static final String COUNT_ALL = "Cart.countAllProductCart";

    @Id
    protected int idProd;
    protected int quantity;

    public Cart(int idProd, int quantity) {
        this.idProd = idProd;
        this.quantity = quantity;
    }

    public Cart() {}

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
