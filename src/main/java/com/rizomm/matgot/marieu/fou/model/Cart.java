package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.Cart.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Cart c order by c.idCommande asc"),
        @NamedQuery(name = DELETE_ALL, query = " delete from Cart"),
})
public class Cart implements Serializable{

    public static final String FIND_ALL = "Cart.findAllOrder";
    public static final String DELETE_ALL = "Cart.deleteAllOrder";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int idCommande;
    //protected int idProduit;

    public Cart(int idCommande) {
        this.idCommande = idCommande;
    }

    public Cart() {
    }

    public int getId() {
        return idCommande;
    }

    public void setId(int idCommande) {
        this.idCommande = idCommande;
    }
}
