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
    private Long id;
    private String name;
    @NotNull
    private Long idCategory;
    @Size(max = 2000)
    private String description;
    private Float price;
    private int stock;
    private String image;

    public Product(){

    }

    public Product(String name, String description, Long idCategory, Float price, int stock, String image){
        this.name = name;
        this.description = description;
        this.idCategory = idCategory;
        this.price = price;
        this.stock = stock;
        this.image = image;
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
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
