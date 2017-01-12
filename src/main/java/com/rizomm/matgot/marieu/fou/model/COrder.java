package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.COrder.*;
import static com.rizomm.matgot.marieu.fou.model.OrderLine.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from COrder c order by c.idCommande asc"),
        @NamedQuery(name = DELETE_ALL, query = " delete from COrder"),
        @NamedQuery(name = FIND_ALLOL, query = "SELECT c from OrderLine c order by c.idLine asc"),
        @NamedQuery(name = DELETE_ALLOL, query = " SELECT c from OrderLine c")
})
public class COrder implements Serializable{

    public static final String FIND_ALL = "COrder.findAllOrder";
    public static final String DELETE_ALL = "COrder.deleteAllOrder";
    public static final String FIND_ALLOL = "COrder.findAllOrderLine";
    public static final String DELETE_ALLOL = "COrder.deleteAllOrderLine";

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
