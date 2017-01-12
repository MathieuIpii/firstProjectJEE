package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

import static com.rizomm.matgot.marieu.fou.model.Cart.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Cart c"),
        @NamedQuery(name = DELETE_ALL, query = " delete from Cart"),
})
public class Cart implements Serializable{

    public static final String FIND_ALL = "Cart.findAllOrder";
    public static final String DELETE_ALL = "Cart.deleteAllOrder";

    @Id
    protected int id;
    protected Map<Integer, Integer> cart;

    public Cart(Map<Integer, Integer> cart) {
        this.cart = cart;
    }

    public Cart() {
    }

    public Map<Integer, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Integer> cart) {
        this.cart = cart;
    }
}
