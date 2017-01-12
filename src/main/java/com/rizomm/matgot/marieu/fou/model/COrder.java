package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.COrder.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from COrder c order by c.idCommande asc"),
        @NamedQuery(name = DELETE_ALL, query = " delete from COrder")
})
public class COrder implements Serializable{

    public static final String FIND_ALL = "COrder.findAllOrder";
    public static final String DELETE_ALL = "COrder.deleteAllOrder";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int idCommande;
    //protected int idProduit;

    public COrder(int idCommande) {
        this.idCommande = idCommande;
    }

    public COrder() {
    }

    public int getId() {
        return idCommande;
    }

    public void setId(int idCommande) {
        this.idCommande = idCommande;
    }
}
