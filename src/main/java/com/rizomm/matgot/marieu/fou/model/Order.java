package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int idCommande;

    public Order(int idCommande) {
        this.idCommande = idCommande;
    }

    public Order() {
    }

    public int getId() {
        return idCommande;
    }

    public void setId(int idCommande) {
        this.idCommande = idCommande;
    }
}
