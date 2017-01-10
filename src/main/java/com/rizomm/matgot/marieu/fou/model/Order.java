package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import static com.rizomm.matgot.marieu.fou.model.Order.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Order c order by c.idCommande asc"),
        @NamedQuery(name = DELETE_ALL, query = " delete from Order")
})
public class Order implements Serializable{

    public static final String FIND_ALL = "Order.findAllOrder";
    public static final String DELETE_ALL = "Order.deleteAllOrder";

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
