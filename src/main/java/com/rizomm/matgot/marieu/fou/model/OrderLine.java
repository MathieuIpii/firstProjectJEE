package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.COrder.DELETE_ALL;
import static com.rizomm.matgot.marieu.fou.model.COrder.FIND_ALL;

/**
 * Created by Mathieu on 17/11/2016.
 */

//@IdClass(OrderLine.class)
@Entity
public class OrderLine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLine;
    private int idCommande;
    private int idProduit;

    private int quantite;

    public OrderLine(){}

    public OrderLine (int idCommande, int idProduit, int quantite){
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
    }

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
