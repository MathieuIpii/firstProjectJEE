package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;

import com.rizomm.matgot.marieu.fou.model.Product;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
public class Order implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idProd;
    private int quantity;

    public Order(int idProd, int quantity) {
        this.idProd = idProd;
        this.quantity = quantity;
    }

    public Order() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
