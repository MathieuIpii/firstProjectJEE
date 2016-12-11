package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.Product.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT p FROM Product p")
public class Product implements Serializable {

    public static final String FIND_ALL = "Product.findAllProducts";


    @Id
    @GeneratedValue
<<<<<<< HEAD
    private Long reference;
    private String nom;
    private Float prix;
    private String description;
    private int stock;

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
=======
    Long id;
    String name;
    @NotNull
    Long idCategory;
    @Size(max = 2000)
    String description;
    Float price;
    int stock;

    public Product(){

    }

    public Product(String name, String description, Long idCategory, Float price, int stock){
        this.name = name;
        this.description = description;
        this.idCategory = idCategory;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
>>>>>>> origin/master
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
=======
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

>>>>>>> origin/master
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
