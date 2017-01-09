package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.Product.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Product c order by c.id asc"),
        @NamedQuery(name = FIND_ALL_BY_CATEGORY, query = "select c from Product c where c.idCat = :idCategory order by c.id asc"),
        @NamedQuery(name = COUNT_ALL, query = "select count(c) from Product c"),
        @NamedQuery(name = COUNT_ALL_BY_CATEGORY, query = "select count(c) from Product c where c.idCat = :idCategory"),
        @NamedQuery(name = DELETE_ALL, query = " delete from Product"),
})
public class Product implements Serializable {

    public static final String FIND_ALL = "Product.findAllProduct";
    public static final String COUNT_ALL = "Product.countAllProduct";
    public static final String COUNT_ALL_BY_CATEGORY = "Product.countAllProductByCategory";
    public static final String DELETE_ALL = "Product.deleteAllProduct";
    public static final String FIND_ALL_BY_CATEGORY = "Product.findAllProductByCategory";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@ManyToOne
    //@JoinColumn(name = "category_fk", nullable = false)
    //private Category category;
    private int idCat;
    @NotNull(message = "Le stock ne peut pas être nul")
    @Min(value = 0, message = "Le stock ne peut pas être négatif")
    private int stock;
    @NotNull(message = "Le prix ne doit pas être nul")
    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    private double price;
    @NotNull(message = "Le nom ne peut pas être nul")
    private String name;
    @NotNull(message = "La description ne peut pas etre nul")
    @Lob
    @Column
    private String description;
    @NotNull(message = "L'url de l'image ne peut pas être nulle")
    private String urlPicture;

    public Product() {
    }

    public Product(int id, int idCat, int stock, float price, String name, String description, String urlPicture) {
        this.id = id;
        this.idCat = idCat;
        this.stock = stock;
        this.price = Math.floor(price * 100) / 100;
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
    }

    public Product(int idCat, int stock, float price, String name, String description, String urlPicture) {
        this.idCat = idCat;
        this.stock = stock;
        this.price = Math.floor(price * 100) / 100;
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getidCat() {
        return idCat;
    }

    public void setCategory(int idCat) {
        this.idCat = idCat;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return Math.floor(price * 100) / 100;
    }

    public void setPrice(double price) {
        this.price = Math.floor(price * 100) / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }
}
